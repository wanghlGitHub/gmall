package com.atguigu.gmall.auth.controller;

import com.alibaba.fastjson.TypeReference;
import com.atguigu.common.constant.AuthServerConstant;
import com.atguigu.common.exception.BizCodeEnum;
import com.atguigu.common.utils.R;
import com.atguigu.common.vo.MemberResponseVo;
import com.atguigu.gmall.auth.feign.MemberFeignService;
import com.atguigu.gmall.auth.feign.ThirdPartFeignService;
import com.atguigu.gmall.auth.vo.UserLoginVo;
import com.atguigu.gmall.auth.vo.UserRegisterVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.atguigu.common.constant.AuthServerConstant.LOGIN_USER;

/**
 * @program: gmall
 * @description: 登录服务 controller
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/24 11:05 上午
 * @Version: 1.0
 */
@Controller
public class LoginController {


	@Autowired
	private ThirdPartFeignService thirdPartFeignService;

	@Autowired
	private MemberFeignService memberFeignService;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * 发送短信验证码
	 *
	 * @param phone
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/12/24 3:30 下午
	 * @return: com.atguigu.common.utils.R
	 */
	@ResponseBody
	@GetMapping(value = "/sms/sendCode")
	public R sendCode(@RequestParam("phone") String phone) {

		//1、接口防刷
		String redisCode = stringRedisTemplate.opsForValue().get(AuthServerConstant.SMS_CODE_CACHE_PREFIX + phone);
		if (!StringUtils.isEmpty(redisCode)) {
			//活动存入redis的时间，用当前时间减去存入redis的时间，判断用户手机号是否在60s内发送验证码
			long currentTime = Long.parseLong(redisCode.split("_")[1]);
			if (System.currentTimeMillis() - currentTime < 60000) {
				//60s内不能再发
				return R.error(BizCodeEnum.SMS_CODE_EXCEPTION.getCode(), BizCodeEnum.SMS_CODE_EXCEPTION.getMsg());
			}
		}

		//2、验证码的再次效验 redis.存key-phone,value-code
		int code = (int) ((Math.random() * 9 + 1) * 100000);
		String codeNum = String.valueOf(code);
		String redisStorage = codeNum + "_" + System.currentTimeMillis();

		//存入redis，防止同一个手机号在60秒内再次发送验证码
		stringRedisTemplate.opsForValue().set(AuthServerConstant.SMS_CODE_CACHE_PREFIX + phone,
				redisStorage, 10, TimeUnit.MINUTES);

		thirdPartFeignService.sendCode(phone, codeNum);

		return R.ok();
	}


	/**
	 * TODO: 重定向携带数据：利用session原理，将数据放在session中。
	 * TODO:只要跳转到下一个页面取出这个数据以后，session里面的数据就会删掉
	 * TODO：分布下session问题
	 * RedirectAttributes：重定向也可以保留数据，不会丢失
	 * 用户注册
	 *
	 * @return
	 */
	@PostMapping(value = "/register")
	public String register(@Valid UserRegisterVo vos, BindingResult result, RedirectAttributes attributes) {

		//如果有错误回到注册页面
		if (result.hasErrors()) {
			Map<String, String> errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
			attributes.addFlashAttribute("errors", errors);
			//效验出错回到注册页面
			return "redirect:http://auth.gulimall.com/reg.html";
		}

		//1、效验验证码
		String code = vos.getCode();

		//获取存入Redis里的验证码
		String redisCode = stringRedisTemplate.opsForValue().get(AuthServerConstant.SMS_CODE_CACHE_PREFIX + vos.getPhone());
		if (!StringUtils.isEmpty(redisCode)) {
			//截取字符串
			if (code.equals(redisCode.split("_")[0])) {
				//删除验证码;令牌机制
				stringRedisTemplate.delete(AuthServerConstant.SMS_CODE_CACHE_PREFIX + vos.getPhone());
				//验证码通过，真正注册，调用远程服务进行注册
				R register = memberFeignService.register(vos);
				if (register.getCode() == 0) {
					//成功
					return "redirect:http://auth.gulimall.com/login.html";
				} else {
					//失败
					Map<String, String> errors = new HashMap<>();
					errors.put("msg", register.getData("msg", new TypeReference<String>() {
					}));
					attributes.addFlashAttribute("errors", errors);
					return "redirect:http://auth.gulimall.com/reg.html";
				}
			} else {
				//效验出错回到注册页面
				Map<String, String> errors = new HashMap<>();
				errors.put("code", "验证码错误");
				attributes.addFlashAttribute("errors", errors);
				return "redirect:http://auth.gulimall.com/reg.html";
			}
		} else {
			//效验出错回到注册页面
			Map<String, String> errors = new HashMap<>();
			errors.put("code", "验证码错误");
			attributes.addFlashAttribute("errors", errors);
			return "redirect:http://auth.gulimall.com/reg.html";
		}
	}


	/**
	 * 跳登录页面
	 *
	 * @param session
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/12/28 10:59 上午
	 * @return: java.lang.String
	 */
	@GetMapping(value = "/login.html")
	public String loginPage(HttpSession session) {

		//从session先取出来用户的信息，判断用户是否已经登录过了
		Object attribute = session.getAttribute(LOGIN_USER);
		//如果用户没登录那就跳转到登录页面
		if (attribute == null) {
			return "login";
		} else {
			return "redirect:http://gulimall.com";
		}

	}


	/**
	 * 发送登录请求
	 *
	 * @param vo
	 * @param attributes
	 * @param session
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/12/28 11:26 上午
	 * @return: java.lang.String
	 */
	@PostMapping(value = "/login")
	public String login(UserLoginVo vo, RedirectAttributes attributes, HttpSession session) {

		//远程登录
		R login = memberFeignService.login(vo);

		if (login.getCode() == 0) {
			MemberResponseVo data = login.getData("data", new TypeReference<MemberResponseVo>() {
			});
			session.setAttribute(LOGIN_USER, data);
			return "redirect:http://gulimall.com";
		} else {
			Map<String, String> errors = new HashMap<>();
			errors.put("msg", login.getData("msg", new TypeReference<String>() {
			}));
			attributes.addFlashAttribute("errors", errors);
			return "redirect:http://auth.gulimall.com/login.html";
		}
	}


	@GetMapping(value = "/loguot.html")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute(LOGIN_USER);
		request.getSession().invalidate();
		return "redirect:http://gulimall.com";
	}
}
