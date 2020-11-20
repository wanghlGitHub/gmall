package com.atguigu.gmall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.atguigu.gmall.member.dao")
@SpringBootApplication
public class GuliMemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuliMemberApplication.class, args);
	}

}
