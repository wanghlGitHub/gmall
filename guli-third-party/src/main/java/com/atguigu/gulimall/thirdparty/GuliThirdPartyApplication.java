package com.atguigu.gulimall.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author heliang.wang
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GuliThirdPartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuliThirdPartyApplication.class, args);
    }

}
