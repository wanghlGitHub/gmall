package com.atguigu.gmall.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author heliang.wang
 */
@MapperScan("com.atguigu.gmall.order.dao")
@SpringBootApplication
public class GuliOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuliOrderApplication.class, args);
	}

}
