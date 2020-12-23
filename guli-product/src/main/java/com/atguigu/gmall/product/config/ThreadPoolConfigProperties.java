package com.atguigu.gmall.product.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: gmall
 * @description: 线程池配置类
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/23 10:04 上午
 * @Version: 1.0
 */
@ConfigurationProperties(prefix = "gmall.thread")
@Data
public class ThreadPoolConfigProperties {

	private Integer coreSize;

	private Integer maxSize;

	private Integer keepAliveTime;
}
