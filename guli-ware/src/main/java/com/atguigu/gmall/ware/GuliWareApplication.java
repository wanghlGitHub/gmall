package com.atguigu.gmall.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 库存服务主启动类
 *
 * @author heliang.wang
 */
@EnableFeignClients(basePackages = "com.atguigu.gmall.ware.feign")
@EnableDiscoveryClient
@MapperScan("com.atguigu.gmall.ware.dao")
@SpringBootApplication
public class GuliWareApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuliWareApplication.class, args);
	}

}
