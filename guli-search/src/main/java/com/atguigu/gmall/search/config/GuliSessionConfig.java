package com.atguigu.gmall.search.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * @program: gmall
 * @description: spring-session 配置类
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/29 9:53 上午
 * @Version: 1.0
 */
@Configuration
public class GuliSessionConfig {

	@Bean
	public CookieSerializer cookieSerializer() {

		DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();

		//放大作用域
		cookieSerializer.setDomainName("gulimall.com");
		cookieSerializer.setCookieName("GULISESSION");

		return cookieSerializer;
	}


	@Bean
	public RedisSerializer<Object> springSessionDefaultRedisSerializer() {
		return new GenericJackson2JsonRedisSerializer();
	}

}
