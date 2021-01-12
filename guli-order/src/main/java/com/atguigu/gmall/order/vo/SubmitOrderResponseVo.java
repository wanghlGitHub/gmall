package com.atguigu.gmall.order.vo;

import com.atguigu.gmall.order.entity.OrderEntity;
import lombok.Data;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/6 9:07 上午
 * @Version: 1.0
 */
@Data
public class SubmitOrderResponseVo {

	private OrderEntity order;

	/** 错误状态码 **/
	private Integer code;
}
