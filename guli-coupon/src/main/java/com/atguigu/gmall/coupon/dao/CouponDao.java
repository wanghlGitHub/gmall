package com.atguigu.gmall.coupon.dao;

import com.atguigu.gmall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:43:49
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
