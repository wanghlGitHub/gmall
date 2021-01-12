package com.atguigu.gmall.ware.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/12 9:06 上午
 */
@FeignClient("guli-order")
public interface OrderFeignService {

	/**
	 * 查询订单状态
	 *
	 * @param orderSn
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2021/1/12 9:07 上午
	 * @return: com.atguigu.common.utils.R
	 */
	@GetMapping(value = "/order/order/status/{orderSn}")
	R getOrderStatus(@PathVariable("orderSn") String orderSn);
}
