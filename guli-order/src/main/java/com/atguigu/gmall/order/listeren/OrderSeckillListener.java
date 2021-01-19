package com.atguigu.gmall.order.listeren;

import com.atguigu.common.to.mq.SeckillOrderTo;
import com.atguigu.gmall.order.service.OrderService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @program: gmall
 * @description: 秒杀监听队列
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/18 3:35 下午
 * @Version: 1.0
 */
@Slf4j
@Component
@RabbitListener(queues = "order.seckill.order.queue")
public class OrderSeckillListener {

	@Autowired
	private OrderService orderService;

	@RabbitHandler
	public void listener(SeckillOrderTo orderTo, Channel channel, Message message) throws IOException {

		log.info("准备创建秒杀单的详细信息...");

		try {
			orderService.createSeckillOrder(orderTo);
			channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
		} catch (Exception e) {
			channel.basicReject(message.getMessageProperties().getDeliveryTag(),true);
		}

	}
}
