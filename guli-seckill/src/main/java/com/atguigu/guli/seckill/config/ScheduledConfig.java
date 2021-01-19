package com.atguigu.guli.seckill.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/13 7:21 下午
 * @Version: 1.0
 */
@EnableAsync //开启异步任务
@EnableScheduling // 开启定时任务，spring 默认自带的
@Configuration
public class ScheduledConfig {
}
