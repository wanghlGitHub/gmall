package com.atguigu.gmall.product.dao;

import com.atguigu.gmall.product.entity.SkuSaleAttrValueEntity;
import com.atguigu.gmall.product.vo.SkuItemSaleAttrVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * sku销售属性&值
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:38:55
 */
@Mapper
public interface SkuSaleAttrValueDao extends BaseMapper<SkuSaleAttrValueEntity> {

	List<SkuItemSaleAttrVo> getSaleAttrBySpuId(@Param("spuId") Long spuId);

	List<String> getSkuSaleAttrValuesAsStringList(@Param("skuId") Long skuId);
}
