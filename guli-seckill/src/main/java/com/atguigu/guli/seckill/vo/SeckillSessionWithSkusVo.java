package com.atguigu.guli.seckill.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/13 7:27 下午
 * @Version: 1.0
 */
@Data
public class SeckillSessionWithSkusVo {

	private Long id;
	/**
	 * 场次名称
	 */
	private String name;
	/**
	 * 每日开始时间
	 */
	private Date startTime;
	/**
	 * 每日结束时间
	 */
	private Date endTime;
	/**
	 * 启用状态
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createTime;

	private List<SeckillSkuVo> relationSkus;
}
