package com.atguigu.gmall.product.service;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.gmall.product.entity.SpuInfoEntity;
import com.atguigu.gmall.product.vo.SpuSaveVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * spu信息
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:38:55
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

	PageUtils queryPage(Map<String, Object> params);

	void saveSpuInfo(SpuSaveVo vo);

	void saveBaseSpuInfo(SpuInfoEntity infoEntity);

	PageUtils queryPageByCondition(Map<String, Object> params);

	SpuInfoEntity getSpuInfoBySkuId(Long skuId);
}

