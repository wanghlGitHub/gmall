package com.atguigu.gmall.member.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: gmall
 * @description: 优惠券服务
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/11/20 5:06 下午
 */
@FeignClient("guli-coupon")
public interface CouponFeign {

	@RequestMapping("/coupon/coupon/info/{id}")
	R info(@PathVariable("id") Long id);
}
