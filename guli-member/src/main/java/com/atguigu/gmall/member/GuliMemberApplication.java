package com.atguigu.gmall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author heliang.wang
 */
@EnableFeignClients(basePackages = "com.atguigu.gmall.member.feign")
@EnableDiscoveryClient
@MapperScan("com.atguigu.gmall.member.dao")
@SpringBootApplication
public class GuliMemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuliMemberApplication.class, args);
	}

}
