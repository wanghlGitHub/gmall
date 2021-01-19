package com.atguigu.gmall.order.dao;

import com.atguigu.gmall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 订单
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:36:19
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {

	/**
	 * 修改订单状态
	 * @param orderSn
	 * @param code
	 * @param payType
	 */
	void updateOrderStatus(@Param("orderSn") String orderSn,
						   @Param("code") Integer code,
						   @Param("payType") Integer payType);
}
