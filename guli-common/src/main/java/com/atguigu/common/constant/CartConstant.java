package com.atguigu.common.constant;

/**
 * @program: gmall
 * @description: 购物车常量类
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/30 10:22 上午
 * @Version: 1.0
 */
public class CartConstant {

	/**
	 * 临时用户的 cookie name
	 */
	public final static String TEMP_USER_COOKIE_NAME = "user-key";
	/**
	 * 临时用户 cookie 过期时间 ，单位：秒
	 */
	public final static int TEMP_USER_COOKIE_TIMEOUT = 60*60*24*30;

	public final static String CART_PREFIX = "gulimall:cart:";
}
