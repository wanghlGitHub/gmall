package com.atguigu.gmall.product.service;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.gmall.product.entity.AttrEntity;
import com.atguigu.gmall.product.vo.AttrGroupRelationVo;
import com.atguigu.gmall.product.vo.AttrRespVo;
import com.atguigu.gmall.product.vo.AttrVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:38:55
 */
public interface AttrService extends IService<AttrEntity> {

	PageUtils queryPage(Map<String, Object> params);

	void saveAttr(AttrVo attr);

	PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId, String type);

	AttrRespVo getAttrInfo(Long attrId);

	void updateAttr(AttrVo attr);

	List<AttrEntity> getRelationAttr(Long attrgroupId);

	void deleteRelation(AttrGroupRelationVo[] vos);

	PageUtils getNoRelationAttr(Map<String, Object> params, Long attrgroupId);
}

