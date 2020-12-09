package com.atguigu.gmall.product.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: gmall
 * @description: redisson 配置
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/9 11:26 上午
 * @Version: 1.0
 */
@Configuration
public class MyRedissonConfig {

	@Value("${spring.redis.url}")
	private String redisUrl;
	@Value("${spring.redis.port}")
	private String redisPort;

	@Bean(destroyMethod = "shutdown")
	public RedissonClient redissonClient() {
		//1、创建配置
		Config config = new Config();
		//Redis url should start with redis:// or rediss://
		config.useSingleServer().setAddress("redis://" + redisUrl + ":" + redisPort);

		//2、根据Config创建出RedissonClient实例
		RedissonClient redissonClient = Redisson.create(config);
		return redissonClient;
	}
}
