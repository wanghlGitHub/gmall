package com.atguigu.gmall.ware.controller;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;
import com.atguigu.gmall.ware.entity.WareInfoEntity;
import com.atguigu.gmall.ware.service.WareInfoService;
import com.atguigu.gmall.ware.vo.FareVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 仓库信息
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:41:34
 */
@RestController
@RequestMapping("ware/wareinfo")
public class WareInfoController {

	@Autowired
	private WareInfoService wareInfoService;

	/**
	 * 查运费
	 *
	 * @param addrId
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2021/1/6 1:50 下午
	 * @return: com.atguigu.common.utils.R
	 */
	@GetMapping(value = "/fare")
	public R getFare(@RequestParam("addrId") Long addrId) {

		FareVo fare = wareInfoService.getFare(addrId);

		return R.ok().setData(fare);
	}

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = wareInfoService.queryPage(params);

		return R.ok().put("page", page);
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id) {
		WareInfoEntity wareInfo = wareInfoService.getById(id);

		return R.ok().put("wareInfo", wareInfo);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody WareInfoEntity wareInfo) {
		wareInfoService.save(wareInfo);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody WareInfoEntity wareInfo) {
		wareInfoService.updateById(wareInfo);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids) {
		wareInfoService.removeByIds(Arrays.asList(ids));

		return R.ok();
	}

}
