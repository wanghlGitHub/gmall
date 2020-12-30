package com.atguigu.gmall.cart.interceptor;

import com.atguigu.common.vo.MemberResponseVo;
import com.atguigu.gmall.cart.to.UserInfoTo;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

import static com.atguigu.common.constant.AuthServerConstant.LOGIN_USER;
import static com.atguigu.common.constant.CartConstant.TEMP_USER_COOKIE_NAME;
import static com.atguigu.common.constant.CartConstant.TEMP_USER_COOKIE_TIMEOUT;

/**
 * @program: gmall
 * @description: 购物车全局拦截器
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/30 10:20 上午
 * @Version: 1.0
 */
public class CartInterceptor implements HandlerInterceptor {

	public static ThreadLocal<UserInfoTo> toThreadLocal = new ThreadLocal<>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		UserInfoTo userInfoTo = new UserInfoTo();

		HttpSession session = request.getSession();
		//获得当前登录用户的信息
		MemberResponseVo memberResponseVo = (MemberResponseVo) session.getAttribute(LOGIN_USER);

		if (memberResponseVo != null) {
			//用户登录了
			userInfoTo.setUserId(memberResponseVo.getId());
		}

		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				//user-key
				String name = cookie.getName();
				if (name.equals(TEMP_USER_COOKIE_NAME)) {
					userInfoTo.setUserKey(cookie.getValue());
					//标记为已是临时用户
					userInfoTo.setTempUser(true);
				}
			}
		}

		//如果没有临时用户一定分配一个临时用户
		if (StringUtils.isEmpty(userInfoTo.getUserKey())) {
			String uuid = UUID.randomUUID().toString();
			userInfoTo.setUserKey(uuid);
		}

		//目标方法执行之前
		toThreadLocal.set(userInfoTo);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

		//获取当前用户的值
		UserInfoTo userInfoTo = toThreadLocal.get();

		//如果没有临时用户一定保存一个临时用户
		if (!userInfoTo.getTempUser()) {
			//创建一个cookie
			Cookie cookie = new Cookie(TEMP_USER_COOKIE_NAME, userInfoTo.getUserKey());
			//扩大作用域
			cookie.setDomain("gulimall.com");
			//设置过期时间
			cookie.setMaxAge(TEMP_USER_COOKIE_TIMEOUT);
			response.addCookie(cookie);
		}
	}
}
