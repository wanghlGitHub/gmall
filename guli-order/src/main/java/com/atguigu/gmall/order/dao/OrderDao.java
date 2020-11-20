package com.atguigu.gmall.order.dao;

import com.atguigu.gmall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:36:19
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
