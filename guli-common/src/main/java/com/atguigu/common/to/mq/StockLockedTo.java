package com.atguigu.common.to.mq;

import lombok.Data;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/11 4:34 下午
 * @Version: 1.0
 */
@Data
public class StockLockedTo {

	/** 库存工作单的id **/
	private Long id;

	/** 工作单详情的所有信息 **/
	private StockDetailTo detailTo;
}
