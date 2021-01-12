package com.atguigu.gmall.ware.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/6 1:52 下午
 */
@FeignClient("guli-member")
public interface MemberFeignService {

	/**
	 * 根据id获取用户地址信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/member/memberreceiveaddress/info/{id}")
	R info(@PathVariable("id") Long id);
}
