package com.atguigu.gmall.coupon.controller;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;
import com.atguigu.gmall.coupon.entity.SeckillSessionEntity;
import com.atguigu.gmall.coupon.service.SeckillSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 秒杀活动场次
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:43:49
 */
@RestController
@RequestMapping("coupon/seckillsession")
public class SeckillSessionController {
	@Autowired
	private SeckillSessionService seckillSessionService;

	/**
	 * 查询最近三天需要参加秒杀商品的信息
	 *
	 * @param
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2021/1/13 7:06 下午
	 * @return: com.atguigu.common.utils.R
	 */
	@GetMapping(value = "/Lates3DaySession")
	public R getLates3DaySession() {

		List<SeckillSessionEntity> seckillSessionEntities = seckillSessionService.getLates3DaySession();

		return R.ok().setData(seckillSessionEntities);
	}

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = seckillSessionService.queryPage(params);

		return R.ok().put("page", page);
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id) {
		SeckillSessionEntity seckillSession = seckillSessionService.getById(id);

		return R.ok().put("seckillSession", seckillSession);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody SeckillSessionEntity seckillSession) {
		seckillSessionService.save(seckillSession);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody SeckillSessionEntity seckillSession) {
		seckillSessionService.updateById(seckillSession);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids) {
		seckillSessionService.removeByIds(Arrays.asList(ids));

		return R.ok();
	}

}
