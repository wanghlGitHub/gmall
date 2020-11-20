package com.atguigu.gmall.order.dao;

import com.atguigu.gmall.order.entity.OrderOperateHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单操作历史记录
 * 
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:36:20
 */
@Mapper
public interface OrderOperateHistoryDao extends BaseMapper<OrderOperateHistoryEntity> {
	
}
