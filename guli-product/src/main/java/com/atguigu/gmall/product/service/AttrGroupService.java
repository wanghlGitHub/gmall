package com.atguigu.gmall.product.service;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.gmall.product.entity.AttrGroupEntity;
import com.atguigu.gmall.product.vo.AttrGroupWithAttrsVo;
import com.atguigu.gmall.product.vo.SpuItemAttrGroupVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 属性分组
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:38:55
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

	PageUtils queryPage(Map<String, Object> params);

	PageUtils queryPage(Map<String, Object> params, Long catelogId);

	List<AttrGroupWithAttrsVo> getAttrGroupWithAttrsByCatelogId(Long catelogId);

	List<SpuItemAttrGroupVo> getAttrGroupWithAttrsBySpuId(Long spuId, Long catalogId);
}

