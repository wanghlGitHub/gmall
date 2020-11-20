package com.atguigu.gmall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.atguigu.gmall.product.dao")
@SpringBootApplication
public class GuliProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuliProductApplication.class, args);
	}

}
