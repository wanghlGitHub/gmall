package com.atguigu.gmall.member.exception;

/**
 * @program: gmall
 * @description: 注册-用户名已存在
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/28 10:28 上午
 * @Version: 1.0
 */
public class UsernameException extends RuntimeException {

	public UsernameException() {
		super("用户名已存在");
	}
}
