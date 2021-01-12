package com.atguigu.gmall.order.feign;

import com.atguigu.gmall.order.vo.MemberAddressVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/6 9:33 上午
 */
@FeignClient("guli-member")
public interface MemberFeignService {

	@GetMapping(value = "/member/memberreceiveaddress/{memberId}/address")
	List<MemberAddressVo> getAddress(@PathVariable("memberId") Long memberId);
}
