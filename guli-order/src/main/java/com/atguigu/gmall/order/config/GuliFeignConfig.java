package com.atguigu.gmall.order.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: gmall
 * @description: feign 发送请求之前的拦截器构造，默认的拦截器不会携带原请求中的 header 信息，导致请求数据丢失
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/6 10:36 上午
 * @Version: 1.0
 */
@Configuration
public class GuliFeignConfig {

	@Bean
	public RequestInterceptor requestInterceptor() {
		return requestTemplate -> {
			//获取上下文中请求的所有Attributes
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			if (requestAttributes != null) {
				//1、老的请求
				HttpServletRequest request = requestAttributes.getRequest();
				if (request != null) {
					//2、同步请求头的数据（主要是cookie）
					//把老请求的cookie值放到新请求上来，进行一个同步
					String cookie = request.getHeader("Cookie");
					requestTemplate.header("Cookie", cookie);
				}
			}
		};
	}
}
