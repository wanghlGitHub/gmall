package com.atguigu.gmall.order.dao;

import com.atguigu.gmall.order.entity.OrderSettingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单配置信息
 * 
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:36:19
 */
@Mapper
public interface OrderSettingDao extends BaseMapper<OrderSettingEntity> {
	
}
