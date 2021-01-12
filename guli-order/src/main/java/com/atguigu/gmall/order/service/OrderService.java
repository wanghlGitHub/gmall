package com.atguigu.gmall.order.service;

import com.atguigu.gmall.order.vo.OrderConfirmVo;
import com.atguigu.gmall.order.vo.OrderSubmitVo;
import com.atguigu.gmall.order.vo.SubmitOrderResponseVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gmall.order.entity.OrderEntity;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * 订单
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:36:19
 */
public interface OrderService extends IService<OrderEntity> {

	PageUtils queryPage(Map<String, Object> params);

	/**
	 * 订单确认页面
	 *
	 * @param
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2021/1/6 9:31 上午
	 * @return: com.atguigu.gmall.order.vo.OrderConfirmVo
	 */
	OrderConfirmVo confirmOrder() throws ExecutionException, InterruptedException;

	SubmitOrderResponseVo submitOrder(OrderSubmitVo vo);

	OrderEntity getOrderByOrderSn(String orderSn);

	/**
	 * 关闭订单
	 *
	 * @param orderEntity
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2021/1/12 10:45 上午
	 * @return: void
	 */
	void closeOrder(OrderEntity orderEntity);
}

