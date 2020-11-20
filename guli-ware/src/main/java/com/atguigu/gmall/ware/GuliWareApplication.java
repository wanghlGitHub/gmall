package com.atguigu.gmall.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author heliang.wang
 */
@MapperScan("com.atguigu.gmall.ware.dao")
@SpringBootApplication
public class GuliWareApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuliWareApplication.class, args);
	}

}
