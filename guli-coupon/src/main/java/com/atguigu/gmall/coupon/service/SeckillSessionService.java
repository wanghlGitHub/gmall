package com.atguigu.gmall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gmall.coupon.entity.SeckillSessionEntity;

import java.util.List;
import java.util.Map;

/**
 * 秒杀活动场次
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:43:49
 */
public interface SeckillSessionService extends IService<SeckillSessionEntity> {

	PageUtils queryPage(Map<String, Object> params);

	/**
	 * 查询最近三天需要参加秒杀商品的信息
	 *
	 * @param
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2021/1/13 7:07 下午
	 * @return: java.util.List<com.atguigu.gmall.coupon.entity.SeckillSessionEntity>
	 */
	List<SeckillSessionEntity> getLates3DaySession();

}

