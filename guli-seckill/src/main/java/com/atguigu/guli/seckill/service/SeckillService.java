package com.atguigu.guli.seckill.service;

import com.atguigu.guli.seckill.to.SeckillSkuRedisTo;

import java.util.List;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/13 7:23 下午
 */
public interface SeckillService {

	/**
	 * 上架最近三天的秒杀活动
	 *
	 * @param
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2021/1/13 7:25 下午
	 * @return: void
	 */
	void uploadSeckillSkuLatest3Days();

	/**
	 * 获取当前场次的秒杀商品信息
	 *
	 * @param
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2021/1/19 10:58 上午
	 * @return: java.util.List<com.atguigu.guli.seckill.to.SeckillSkuRedisTo>
	 */
	List<SeckillSkuRedisTo> getCurrentSeckillSkus();

	/**
	 * 根据skuId查询商品是否参加秒杀活动
	 *
	 * @param skuId
	 * @return
	 */
	SeckillSkuRedisTo getSkuSeckilInfo(Long skuId);

	/**
	 * 当前商品进行秒杀（秒杀开始）
	 *
	 * @param killId
	 * @param key
	 * @param num
	 * @return
	 */
	String kill(String killId, String key, Integer num) throws InterruptedException;
}
