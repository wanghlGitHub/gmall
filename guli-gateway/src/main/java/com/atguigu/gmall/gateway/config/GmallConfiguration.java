package com.atguigu.gmall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @program: gmall
 * @description: 网关层 统一配置 跨域
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/11/21 6:16 下午
 * @Version: 1.0
 */
@Configuration
public class GmallConfiguration {

	@Bean
	public CorsWebFilter corsWebFilter() {
		UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		corsConfiguration.addAllowedOrigin("*");
		corsConfiguration.setAllowCredentials(true);
		corsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
		return new CorsWebFilter(corsConfigurationSource);
	}
}
