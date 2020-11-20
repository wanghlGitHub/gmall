package com.atguigu.gmall.product.dao;

import com.atguigu.gmall.product.entity.AttrEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品属性
 * 
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:38:55
 */
@Mapper
public interface AttrDao extends BaseMapper<AttrEntity> {
	
}
