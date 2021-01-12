package com.atguigu.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: gmall
 * @description: 无库存抛出异常
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/6 9:09 上午
 * @Version: 1.0
 */
public class NoStockException extends RuntimeException {

	@Getter
	@Setter
	private Long skuId;

	public NoStockException(Long skuId) {
		super("商品id："+ skuId + "库存不足！");
	}

	public NoStockException(String msg) {
		super(msg);
	}
}
