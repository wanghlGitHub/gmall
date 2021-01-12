package com.atguigu.gmall.order.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: gmall
 * @description: 线程池配置类
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/23 10:07 上午
 * @Version: 1.0
 */
@EnableConfigurationProperties(ThreadPoolConfigProperties.class)
@Configuration
public class MyThreadConfig {

	@Bean
	public ThreadPoolExecutor threadPoolExecutor(ThreadPoolConfigProperties pool) {
		return new ThreadPoolExecutor(
				pool.getCoreSize(),
				pool.getMaxSize(),
				pool.getKeepAliveTime(),
				TimeUnit.SECONDS,
				new LinkedBlockingDeque<>(100000),
				Executors.defaultThreadFactory(),
				new ThreadPoolExecutor.AbortPolicy()
		);
	}
}
