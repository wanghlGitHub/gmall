package com.atguigu.guli.seckill.to;

import com.atguigu.guli.seckill.vo.SkuInfoVo;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/13 7:32 下午
 * @Version: 1.0
 */
@Data
public class SeckillSkuRedisTo {

	/**
	 * 活动id
	 */
	private Long promotionId;
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
	 * 秒杀总量
	 */
	private Integer seckillCount;
	/**
	 * 每人限购数量
	 */
	private Integer seckillLimit;
	/**
	 * 排序
	 */
	private Integer seckillSort;

	//sku的详细信息
	private SkuInfoVo skuInfo;

	//当前商品秒杀的开始时间
	private Long startTime;

	//当前商品秒杀的结束时间
	private Long endTime;

	//当前商品秒杀的随机码
	private String randomCode;
}
