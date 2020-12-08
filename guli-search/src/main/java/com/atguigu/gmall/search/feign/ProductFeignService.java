package com.atguigu.gmall.search.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/7 10:23 上午
 * @Version: 1.0
 */
@FeignClient("guli-product")
public interface ProductFeignService {

    @GetMapping("/product/attr/info/{attrId}")
	R attrInfo(@PathVariable("attrId") Long attrId);

}
