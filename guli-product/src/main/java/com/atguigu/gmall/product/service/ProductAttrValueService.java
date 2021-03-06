package com.atguigu.gmall.product.service;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.gmall.product.entity.ProductAttrValueEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * spu属性值
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:38:55
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

	PageUtils queryPage(Map<String, Object> params);

	void saveProductAttr(List<ProductAttrValueEntity> collect);

	List<ProductAttrValueEntity> baseAttrlistforspu(Long spuId);

	void updateSpuAttr(Long spuId, List<ProductAttrValueEntity> entities);
}

