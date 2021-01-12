package com.atguigu.gmall.ware.service;

import com.atguigu.common.to.OrderTo;
import com.atguigu.common.to.mq.StockLockedTo;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gmall.ware.entity.WareSkuEntity;
import com.atguigu.gmall.ware.vo.SkuHasStockVo;
import com.atguigu.gmall.ware.vo.WareSkuLockVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 商品库存
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:41:34
 */
public interface WareSkuService extends IService<WareSkuEntity> {

	PageUtils queryPage(Map<String, Object> params);

	/**
	 * 添加库存
	 *
	 * @param skuId
	 * @param wareId
	 * @param skuNum
	 */
	void addStock(Long skuId, Long wareId, Integer skuNum);

	/**
	 * 判断是否有库存
	 *
	 * @param skuIds
	 * @return
	 */
	List<SkuHasStockVo> getSkuHasStock(List<Long> skuIds);

	/**
	 * 锁定库存
	 *
	 * @param vo
	 * @return
	 */
	boolean orderLockStock(WareSkuLockVo vo);


	/**
	 * 解锁库存
	 *
	 * @param to
	 */
	void unlockStock(StockLockedTo to);

	/**
	 * 解锁订单
	 *
	 * @param orderTo
	 */
	void unlockStock(OrderTo orderTo);
}

