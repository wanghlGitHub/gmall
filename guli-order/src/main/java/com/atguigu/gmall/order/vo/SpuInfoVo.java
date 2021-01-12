package com.atguigu.gmall.order.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/12 10:58 上午
 * @Version: 1.0
 */
@Data
public class SpuInfoVo {

	/**
	 * 商品id
	 */
	private Long id;
	/**
	 * 商品名称
	 */
	private String spuName;
	/**
	 * 商品描述
	 */
	private String spuDescription;
	/**
	 * 所属分类id
	 */
	private Long catalogId;
	/**
	 * 品牌id
	 */
	private Long brandId;

	/**
	 * 品牌名
	 */
	private String brandName;

	/**
	 *
	 */
	private BigDecimal weight;
	/**
	 * 上架状态[0 - 下架，1 - 上架]
	 */
	private Integer publishStatus;
	/**
	 *
	 */
	private Date createTime;
	/**
	 *
	 */
	private Date updateTime;
}
