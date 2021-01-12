package com.atguigu.gmall.order.to;

import com.atguigu.gmall.order.entity.OrderEntity;
import com.atguigu.gmall.order.entity.OrderItemEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/6 3:22 下午
 * @Version: 1.0
 */
@Data
public class OrderCreateTo {

	private OrderEntity order;

	private List<OrderItemEntity> orderItems;

	/** 订单计算的应付价格 **/
	private BigDecimal payPrice;

	/** 运费 **/
	private BigDecimal fare;
}
