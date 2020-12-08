package com.atguigu.gmall.search.controller;

import com.atguigu.common.es.SkuEsModel;
import com.atguigu.common.exception.BizCodeEnum;
import com.atguigu.common.utils.R;
import com.atguigu.gmall.search.service.ProductSaveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @program: gmall
 * @description: es controller
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/7 10:21 上午
 * @Version: 1.0
 */
@Slf4j
@RequestMapping(value = "/search/save")
@RestController
public class ElasticSaveController {

	@Autowired
	private ProductSaveService productSaveService;


	/**
	 * 上架商品
	 * @param skuEsModels
	 * @return
	 */
	@PostMapping(value = "/product")
	public R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels) {

		boolean status=false;
		try {
			status = productSaveService.productStatusUp(skuEsModels);
		} catch (IOException e) {
			//log.error("商品上架错误{}",e);

			return R.error(BizCodeEnum.PRODUCT_UP_EXCEPTION.getCode(),BizCodeEnum.PRODUCT_UP_EXCEPTION.getMsg());
		}

		if(status){
			return R.error(BizCodeEnum.PRODUCT_UP_EXCEPTION.getCode(),BizCodeEnum.PRODUCT_UP_EXCEPTION.getMsg());
		}else {
			return R.ok();
		}

	}
}
