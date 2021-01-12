package com.atguigu.common.to.mq;

import lombok.Data;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/11 4:33 下午
 * @Version: 1.0
 */
@Data
public class StockDetailTo {

	private Long id;
	/**
	 * sku_id
	 */
	private Long skuId;
	/**
	 * sku_name
	 */
	private String skuName;
	/**
	 * 购买个数
	 */
	private Integer skuNum;
	/**
	 * 工作单id
	 */
	private Long taskId;

	/**
	 * 仓库id
	 */
	private Long wareId;

	/**
	 * 锁定状态
	 */
	private Integer lockStatus;
}
