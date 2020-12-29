package com.atguigu.gmall.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author heliang.wang
 */
@EnableRedisHttpSession
@EnableDiscoveryClient
@SpringBootApplication
public class GuliSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuliSearchApplication.class, args);
	}

}
