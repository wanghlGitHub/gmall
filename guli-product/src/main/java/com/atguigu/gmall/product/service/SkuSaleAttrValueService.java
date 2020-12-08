package com.atguigu.gmall.product.service;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.gmall.product.entity.SkuSaleAttrValueEntity;
import com.atguigu.gmall.product.vo.SkuItemSaleAttrVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * sku销售属性&值
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:38:55
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

	PageUtils queryPage(Map<String, Object> params);

	List<SkuItemSaleAttrVo> getSaleAttrBySpuId(Long spuId);

	List<String> getSkuSaleAttrValuesAsStringList(Long skuId);
}

