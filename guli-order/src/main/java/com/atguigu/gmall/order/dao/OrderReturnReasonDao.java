package com.atguigu.gmall.order.dao;

import com.atguigu.gmall.order.entity.OrderReturnReasonEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 退货原因
 * 
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:36:19
 */
@Mapper
public interface OrderReturnReasonDao extends BaseMapper<OrderReturnReasonEntity> {
	
}
