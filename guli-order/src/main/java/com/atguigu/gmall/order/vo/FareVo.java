package com.atguigu.gmall.order.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/12 10:51 上午
 * @Version: 1.0
 */
@Data
public class FareVo {
	private MemberAddressVo address;

	private BigDecimal fare;
}
