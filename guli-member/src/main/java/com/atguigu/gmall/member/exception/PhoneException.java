package com.atguigu.gmall.member.exception;

/**
 * @program: gmall
 * @description: 注册-手机号已存在异常
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/28 10:27 上午
 * @Version: 1.0
 */
public class PhoneException extends RuntimeException {

	public PhoneException() {
		super("手机号已存在");
	}
}
