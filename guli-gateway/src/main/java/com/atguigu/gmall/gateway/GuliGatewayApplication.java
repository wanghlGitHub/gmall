package com.atguigu.gmall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author heliang.wang
 * 网关不需要数据库操作的东西，排除数据源
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GuliGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuliGatewayApplication.class, args);
	}

}
