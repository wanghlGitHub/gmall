package com.atguigu.gmall.order.feign;

import com.atguigu.common.utils.R;
import com.atguigu.gmall.order.vo.WareSkuLockVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: gmall
 * @description: 库存服务
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/6 9:45 上午
 */
@FeignClient("guli-ware")
public interface WmsFeignService {

	/**
	 * 查询sku是否有库存
	 *
	 * @return
	 */
	@PostMapping(value = "/ware/waresku/hasStock")
	R getSkuHasStock(@RequestBody List<Long> skuIds);


	/**
	 * 查询运费和收货地址信息
	 *
	 * @param addrId
	 * @return
	 */
	@GetMapping(value = "/ware/wareinfo/fare")
	R getFare(@RequestParam("addrId") Long addrId);


	/**
	 * 锁定库存
	 *
	 * @param vo
	 * @return
	 */
	@PostMapping(value = "/ware/waresku/lock/order")
	R orderLockStock(@RequestBody WareSkuLockVo vo);
}
