package com.atguigu.gmall.auth.confing;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: gmall
 * @description: webconfig配置类
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/24 11:06 上午
 * @Version: 1.0
 */
@Configuration
public class GmallWebConfig implements WebMvcConfigurer {

	/**
	 * 适用于单页面跳转，没有什么业务逻辑的那种
	 *
	 * @param registry
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/12/24 11:08 上午
	 * @return: void
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/reg.html").setViewName("reg");
	}
}
