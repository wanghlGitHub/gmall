package com.atguigu.gmall.order.feign;

import com.atguigu.gmall.order.vo.OrderItemVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/6 9:41 上午
 */
@FeignClient("guli-cart")
public interface CartFeignService {

	@GetMapping(value = "/currentUserCartItems")
	List<OrderItemVo> getCurrentCartItems();
}
