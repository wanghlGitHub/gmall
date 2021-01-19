package com.atguigu.common.to.mq;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/19 10:54 上午
 * @Version: 1.0
 */
@Data
public class SeckillOrderTo {

	/**
	 * 订单号
	 */
	private String orderSn;

	/**
	 * 活动场次id
	 */
	private Long promotionSessionId;
	/**
	 * 商品id
	 */
	private Long skuId;
	/**
	 * 秒杀价格
	 */
	private BigDecimal seckillPrice;

	/**
	 * 购买数量
	 */
	private Integer num;

	/**
	 * 会员ID
	 */
	private Long memberId;
}
