package com.atguigu.gmall.order.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @program: gmall
 * @description: 自定义 mq 配置类
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/11 3:46 下午
 * @Version: 1.0
 */
@Configuration
public class MyMQConfig {

	/**
	 * 延迟队列
	 *
	 * @param
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2021/1/11 3:50 下午
	 * @return: org.springframework.amqp.core.Queue
	 */
	@Bean
	public Queue orderDelayQueue() {

		/**
		 * Queue(String name,  队列名字
		 * boolean durable,  是否持久化
		 * boolean exclusive,  是否排他
		 * boolean autoDelete, 是否自动删除
		 * Map<String, Object> arguments) 参数
		 */
		//String name, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
		HashMap<String, Object> arguments = new HashMap<>();
		arguments.put("x-dead-letter-exchange", "order-event-exchange");
		arguments.put("x-dead-letter-routing-key", "order.release.order");
		// 消息过期时间 1分钟
		arguments.put("x-message-ttl", 60000);
		Queue queue = new Queue("order.delay.queue", true, false, false, arguments);
		return queue;
	}

	/**
	 * 普通队列
	 *
	 * @param
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2021/1/11 3:51 下午
	 * @return: org.springframework.amqp.core.Queue
	 */
	@Bean
	public Queue orderReleaseQueue() {

		Queue queue = new Queue("order.release.order.queue", true, false, false);
		return queue;
	}

	/**
	 * 主题交换机  一对多
	 *
	 * @param
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2021/1/11 3:55 下午
	 * @return: org.springframework.amqp.core.Exchange
	 */
	@Bean
	public Exchange orderEventExchange() {
		return new TopicExchange("order-event-exchange", true, false);
	}

	@Bean
	public Binding orderCreateBinding() {
		/*
		 * String destination, 目的地（队列名或者交换机名字）
		 * DestinationType destinationType, 目的地类型（Queue、Exhcange）
		 * String exchange,
		 * String routingKey,
		 * Map<String, Object> arguments
		 * */
		return new Binding("order.delay.queue",
				Binding.DestinationType.QUEUE,
				"order-event-exchange",
				"order.create.order",
				null);
	}

	@Bean
	public Binding orderReleaseBinding() {

		return new Binding("order.release.order.queue",
				Binding.DestinationType.QUEUE,
				"order-event-exchange",
				"order.release.order",
				null);
	}

	/**
	 * 订单释放直接和库存释放进行绑定
	 *
	 * @return
	 */
	@Bean
	public Binding orderReleaseOtherBinding() {

		return new Binding("stock.release.stock.queue",
				Binding.DestinationType.QUEUE,
				"order-event-exchange",
				"order.release.other.#",
				null);
	}


	/**
	 * 商品秒杀队列
	 *
	 * @return
	 */
	@Bean
	public Queue orderSecKillOrrderQueue() {
		Queue queue = new Queue("order.seckill.order.queue", true, false, false);
		return queue;
	}

	@Bean
	public Binding orderSecKillOrrderQueueBinding() {
		//String destination, DestinationType destinationType, String exchange, String routingKey,
		// 			Map<String, Object> arguments
		Binding binding = new Binding(
				"order.seckill.order.queue",
				Binding.DestinationType.QUEUE,
				"order-event-exchange",
				"order.seckill.order",
				null);

		return binding;
	}
}
