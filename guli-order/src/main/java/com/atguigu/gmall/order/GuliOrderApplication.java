package com.atguigu.gmall.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author heliang.wang
 *
 * 使用RabbitMQ
 * 1、引入amqp场景;RabbitAutoConfiguration就会自动生效
 * 2、给容器中自动配置了
 *      RabbitTemplate、AmqpAdmin、CachingConnectionFactory、RabbitMessagingTemplate
 * 3、@EnableRabbit: 开启 rabbitmq
 * 4、	@RabbitListener: 可以标注在类或者方法上面，监听哪些队列
 * 		@RabbitHandler: 只能标注在方法上面，重载区分不同的消息
 *
 *
 *
 * Seata控制分布式事务
 *  1）、每一个微服务必须创建undo_Log
 *  2）、安装事务协调器：seate-server
 *  3）、整合
 *      1、导入依赖
 *      2、解压并启动seata-server：
 *          registry.conf:注册中心配置    修改 registry ： nacos
 *      3、所有想要用到分布式事务的微服务使用seata DataSourceProxy 代理自己的数据源
 *      4、每个微服务，都必须导入   registry.conf   file.conf
 *          vgroup_mapping.{application.name}-fescar-server-group = "default"
 *      5、启动测试分布式事务
 *      6、给分布式大事务的入口标注@GlobalTransactional
 *      7、每一个远程的小事务用@Trabsactional
 */
@EnableAspectJAutoProxy(exposeProxy = true) //开启了aspect动态代理模式,对外暴露代理对象，同一个 service 类下方法互相调用，事务失败解决方法，不使用 jdk 代理的事务
@EnableRedisHttpSession
@EnableRabbit
@EnableDiscoveryClient
@MapperScan("com.atguigu.gmall.order.dao")
@SpringBootApplication
public class GuliOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuliOrderApplication.class, args);
	}

}
