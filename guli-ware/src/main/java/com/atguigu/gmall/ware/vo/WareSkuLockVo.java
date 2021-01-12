package com.atguigu.gmall.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/6 3:26 下午
 * @Version: 1.0
 */
@Data
public class WareSkuLockVo {

	private String orderSn;

	/** 需要锁住的所有库存信息 **/
	private List<OrderItemVo> locks;
}
