package com.atguigu.gmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gmall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:36:19
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

