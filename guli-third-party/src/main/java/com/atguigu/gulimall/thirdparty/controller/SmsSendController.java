package com.atguigu.gulimall.thirdparty.controller;

import com.atguigu.common.utils.R;
import com.atguigu.gulimall.thirdparty.component.SmsComponent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: gmall
 * @description: 发送短信服务
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/24 3:26 下午
 * @Version: 1.0
 */
@RestController
@RequestMapping("/sms")
public class SmsSendController {

	@Resource
	private SmsComponent smsComponent;

	/**
	 * 发送短信
	 *
	 * @param phone
	 * @param code
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/12/24 3:27 下午
	 * @return: com.atguigu.common.utils.R
	 */
	@GetMapping(value = "/sendCode")
	public R sendCode(@RequestParam("phone") String phone, @RequestParam("code") String code) {

		//发送验证码
		smsComponent.sendCode(phone, code);

		return R.ok();
	}
}
