package com.atguigu.gmall.product.service;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.gmall.product.entity.SkuInfoEntity;
import com.atguigu.gmall.product.vo.SkuItemVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * sku信息
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:38:55
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

	PageUtils queryPage(Map<String, Object> params);

	void saveSkuInfo(SkuInfoEntity skuInfoEntity);

	PageUtils queryPageCondition(Map<String, Object> params);

	List<SkuInfoEntity> getSkusBySpuId(Long spuId);

	/**
	 * 查询商品详情
	 *
	 * @param skuId
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/12/7 4:07 下午
	 * @return: com.atguigu.gmall.product.vo.SkuItemVo
	 */
	SkuItemVo item(Long skuId) throws ExecutionException, InterruptedException;
}

