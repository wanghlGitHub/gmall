package com.atguigu.gmall.cart.to;

import lombok.Data;

/**
 * @program: gmall
 * @description: 用户信息：临时购物车、用户购物车使用
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/30 10:17 上午
 * @Version: 1.0
 */
@Data
public class UserInfoTo {

	private Long userId;

	private String userKey;

	/**
	 * 是否临时用户
	 */
	private Boolean tempUser = false;
}
