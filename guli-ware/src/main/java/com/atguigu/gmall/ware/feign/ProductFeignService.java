package com.atguigu.gmall.ware.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商品远程调用
 *
 * @author heliang.wang
 */
@FeignClient("guli-product")
public interface ProductFeignService {

	/**
	 * /product/skuinfo/info/{skuId}
	 * <p>
	 * <p>
	 * 1)、让所有请求过网关；
	 * 1、@FeignClient("guli-gateway")：给guli-gateway所在的机器发请求
	 * 2、/api/product/skuinfo/info/{skuId}
	 * 2）、直接让后台指定服务处理
	 * 1、@FeignClient("guli-gateway")
	 * 2、/product/skuinfo/info/{skuId}
	 *
	 * @return
	 */
	@RequestMapping("/product/skuinfo/info/{skuId}")
	R info(@PathVariable("skuId") Long skuId);
}
