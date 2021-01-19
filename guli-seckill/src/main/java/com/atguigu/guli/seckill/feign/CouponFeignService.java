package com.atguigu.guli.seckill.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/13 7:12 下午
 */
@FeignClient("guli-coupon")
public interface CouponFeignService {

	@GetMapping(value = "/coupon/seckillsession/Lates3DaySession")
	R getLates3DaySession();
}
