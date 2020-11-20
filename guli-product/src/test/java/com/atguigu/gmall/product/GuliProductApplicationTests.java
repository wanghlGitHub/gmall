package com.atguigu.gmall.product;

import com.atguigu.gmall.product.entity.BrandEntity;
import com.atguigu.gmall.product.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class GuliProductApplicationTests {

	@Autowired
	BrandService brandService;

	@Test
	public void contextLoads() {
		BrandEntity brandEntity = new BrandEntity();
		brandEntity.setDescript("测试数据");
		brandEntity.setName("测试品牌");
		brandService.save(brandEntity);
		System.out.println("保存成功！");
	}

}
