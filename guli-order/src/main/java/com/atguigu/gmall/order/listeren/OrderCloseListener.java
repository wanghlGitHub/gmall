package com.atguigu.gmall.order.listeren;

import com.atguigu.gmall.order.entity.OrderEntity;
import com.atguigu.gmall.order.service.OrderService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @program: gmall
 * @description: mq 自动关单
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/12 10:42 上午
 * @Version: 1.0
 */
@RabbitListener(queues = "order.release.order.queue")
@Service
@Slf4j
public class OrderCloseListener {

	@Autowired
	private OrderService orderService;

	@RabbitHandler
	public void listener(OrderEntity orderEntity, Channel channel, Message message) throws IOException {
		log.info("收到过期的订单信息，准备关闭订单" + orderEntity.getOrderSn());
		try {
			orderService.closeOrder(orderEntity);
			//关单成功，手动应答
			channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
		} catch (Exception e) {
			//关单失败，将消息重发会队列
			channel.basicReject(message.getMessageProperties().getDeliveryTag(),true);
		}

	}
}
