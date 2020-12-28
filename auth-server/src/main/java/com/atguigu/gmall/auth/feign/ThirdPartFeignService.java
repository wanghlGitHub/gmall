package com.atguigu.gmall.auth.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: gmall
 * @description: 第三方服务接口调用
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/24 3:25 下午
 * @Version: 1.0
 */
@FeignClient("guli-third-party")
public interface ThirdPartFeignService {

	/**
	 * 发送短信
	 *
	 * @param phone
	 * @param code
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/12/24 3:26 下午
	 * @return: com.atguigu.common.utils.R
	 */
	@GetMapping(value = "/sms/sendCode")
	R sendCode(@RequestParam("phone") String phone, @RequestParam("code") String code);
}
