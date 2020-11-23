package com.atguigu.gmall.product.controller;

import com.atguigu.common.utils.R;
import com.atguigu.gmall.product.entity.CategoryEntity;
import com.atguigu.gmall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


/**
 * 商品三级分类
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:38:55
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	/**
	 * 商品分类树
	 *
	 * @param
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/11/21 3:58 下午
	 * @return: com.atguigu.common.utils.R
	 */
	@RequestMapping("/list/tree")
	public R list() {
		List<CategoryEntity> entities = categoryService.listWithTree();
		return R.ok().put("data", entities);
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{catId}")
	public R info(@PathVariable("catId") Long catId) {
		CategoryEntity category = categoryService.getById(catId);

		return R.ok().put("data", category);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody CategoryEntity category) {
		categoryService.save(category);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody CategoryEntity category) {
		categoryService.updateById(category);

		return R.ok();
	}

	/**
	 * 批量修改
	 *
	 * @param category
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/11/23 12:50 下午
	 * @return: com.atguigu.common.utils.R
	 */
	@RequestMapping("/update/sort")
	public R updateSort(@RequestBody CategoryEntity[] category) {
		categoryService.updateBatchById(Arrays.asList(category));
		return R.ok();
	}

	/**
	 * 删除商品分类
	 *
	 * @param catIds
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/11/21 7:09 下午
	 * @return: com.atguigu.common.utils.R
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] catIds) {
		Boolean res = categoryService.removeMenuByIds(Arrays.asList(catIds));
		return R.ok();
	}

}
