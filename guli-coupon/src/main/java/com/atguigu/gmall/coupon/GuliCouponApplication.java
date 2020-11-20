package com.atguigu.gmall.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.atguigu.gmall.coupon.dao")
@SpringBootApplication
public class GuliCouponApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuliCouponApplication.class, args);
	}

}
