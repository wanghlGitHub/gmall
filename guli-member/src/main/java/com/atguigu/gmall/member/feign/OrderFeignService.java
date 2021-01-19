package com.atguigu.gmall.member.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/12 7:52 下午
 * @Version: 1.0
 */
@FeignClient("guli-order")
public interface OrderFeignService {

	/**
	 * 分页查询当前登录用户的所有订单信息
	 *
	 * @param params
	 * @return
	 */
	@PostMapping("/order/order/listWithItem")
	R listWithItem(@RequestBody Map<String, Object> params);
}
