package com.atguigu.gmall.member.vo;

import lombok.Data;

/**
 * @program: gmall
 * @description: 社交登录 vo
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/28 4:53 下午
 * @Version: 1.0
 */
@Data
public class SocialUser {

	private String access_token;

	private String remind_in;

	private long expires_in;

	private String uid;

	private String isRealName;
}
