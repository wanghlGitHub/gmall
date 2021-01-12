package com.atguigu.gmall.ware.dao;

import com.atguigu.gmall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品库存
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:41:34
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {

	/**
	 * 添加入库信息
	 * @param skuId
	 * @param wareId
	 * @param skuNum
	 */
	void addStock(@Param("skuId") Long skuId, @Param("wareId") Long wareId, @Param("skuNum") Integer skuNum);

	Long getSkuStock(@Param("skuId") Long skuId);

	List<Long> listWareIdHasSkuStock(@Param("skuId") Long skuId);

	Long lockSkuStock(@Param("skuId") Long skuId, @Param("wareId") Long wareId, @Param("num") Integer num);

	/**
	 * 解锁库存
	 * @param skuId
	 * @param wareId
	 * @param num
	 */
	void unLockStock(@Param("skuId") Long skuId, @Param("wareId") Long wareId, @Param("num") Integer num);
}
