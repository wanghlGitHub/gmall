package com.atguigu.gmall.ware.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/6 9:05 上午
 * @Version: 1.0
 */
@Data
public class OrderItemVo {

	private Long skuId;

	private Boolean check;

	private String title;

	private String image;

	/**
	 * 商品套餐属性
	 */
	private List<String> skuAttrValues;

	private BigDecimal price;

	private Integer count;

	private BigDecimal totalPrice;

	/** 商品重量 **/
	private BigDecimal weight = new BigDecimal("0.085");
}
