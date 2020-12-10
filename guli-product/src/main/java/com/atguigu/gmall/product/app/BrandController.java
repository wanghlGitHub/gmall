package com.atguigu.gmall.product.app;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;
import com.atguigu.common.valid.AddGroup;
import com.atguigu.common.valid.UpdateStatusGroup;
import com.atguigu.gmall.product.entity.BrandEntity;
import com.atguigu.gmall.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 品牌
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:38:55
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
	@Autowired
	private BrandService brandService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = brandService.queryPage(params);

		return R.ok().put("page", page);
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{brandId}")
	public R info(@PathVariable("brandId") Long brandId) {
		BrandEntity brand = brandService.getById(brandId);

		return R.ok().put("brand", brand);
	}

	/**
	 * 保存,两种校验模式
	 * JSR303 @Validated 分组校验
	 *
	 * @param brand
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/11/24 11:03 上午
	 * @return: com.atguigu.common.utils.R
	 */
	@RequestMapping("/save")
//	public R save(@Valid @RequestBody BrandEntity brand, BindingResult result) {
	public R save(@Validated({AddGroup.class}) @RequestBody BrandEntity brand) {
//		if (result.hasErrors()) {
//			Map<String, String> map = new HashMap<>();
//			//1、获取校验的错误结果
//			result.getFieldErrors().forEach((item) -> {
//				//FieldError 获取到错误提示
//				String message = item.getDefaultMessage();
//				//获取错误的属性的名字
//				String field = item.getField();
//				map.put(field, message);
//			});
//
//			return R.error(400, "提交的数据不合法").put("data", map);
//		} else {
//
//		}

		brandService.save(brand);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody BrandEntity brand) {
		brandService.updateDetail(brand);

		return R.ok();
	}

	/**
	 * 修改状态
	 *
	 * @param brand
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/11/24 11:08 上午
	 * @return: com.atguigu.common.utils.R
	 */
	@RequestMapping("/update/status")
	public R updateStatus(@Validated(UpdateStatusGroup.class) @RequestBody BrandEntity brand) {
		brandService.updateById(brand);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] brandIds) {
		brandService.removeByIds(Arrays.asList(brandIds));

		return R.ok();
	}

}