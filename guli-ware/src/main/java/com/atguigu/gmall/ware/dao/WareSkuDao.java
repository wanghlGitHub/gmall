package com.atguigu.gmall.ware.dao;

import com.atguigu.gmall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:41:34
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
