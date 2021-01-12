package com.atguigu.gmall.order.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/12 10:52 上午
 */
@FeignClient("guli-product")
public interface ProductFeignService {

	/**
	 * 根据skuId查询spu的信息
	 *
	 * @param skuId
	 * @return
	 */
	@GetMapping(value = "/product/spuinfo/skuId/{skuId}")
	R getSpuInfoBySkuId(@PathVariable("skuId") Long skuId);
}
