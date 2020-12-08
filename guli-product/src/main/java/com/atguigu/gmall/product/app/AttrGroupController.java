package com.atguigu.gmall.product.app;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;
import com.atguigu.gmall.product.entity.AttrEntity;
import com.atguigu.gmall.product.entity.AttrGroupEntity;
import com.atguigu.gmall.product.service.AttrAttrgroupRelationService;
import com.atguigu.gmall.product.service.AttrGroupService;
import com.atguigu.gmall.product.service.AttrService;
import com.atguigu.gmall.product.service.CategoryService;
import com.atguigu.gmall.product.vo.AttrGroupRelationVo;
import com.atguigu.gmall.product.vo.AttrGroupWithAttrsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 属性分组
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:38:55
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
	@Autowired
	private AttrGroupService attrGroupService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	AttrService attrService;
	@Autowired
	AttrAttrgroupRelationService relationService;

	@PostMapping("/attr/relation")
	public R addRelation(@RequestBody List<AttrGroupRelationVo> vos) {
		relationService.saveBatch(vos);
		return R.ok();
	}

	/**
	 * 查询商品分组的所有属性
	 *
	 * @param catelogId
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/11/26 4:09 下午
	 * @return: com.atguigu.common.utils.R
	 */
	@GetMapping("/{catelogId}/withattr")
	public R getAttrGroupWithAttrs(@PathVariable("catelogId") Long catelogId) {

		//1、查出当前分类下的所有属性分组，
		//2、查出每个属性分组的所有属性
		List<AttrGroupWithAttrsVo> vos = attrGroupService.getAttrGroupWithAttrsByCatelogId(catelogId);
		return R.ok().put("data", vos);
	}


	@GetMapping("/{attrgroupId}/attr/relation")
	public R attrRelation(@PathVariable("attrgroupId") Long attrgroupId) {
		List<AttrEntity> entities = attrService.getRelationAttr(attrgroupId);
		return R.ok().put("data", entities);
	}

	@GetMapping("/{attrgroupId}/noattr/relation")
	public R attrNoRelation(@PathVariable("attrgroupId") Long attrgroupId,
							@RequestParam Map<String, Object> params) {
		PageUtils page = attrService.getNoRelationAttr(params, attrgroupId);
		return R.ok().put("page", page);
	}

	@PostMapping("/attr/relation/delete")
	public R deleteRelation(@RequestBody AttrGroupRelationVo[] vos) {
		attrService.deleteRelation(vos);
		return R.ok();
	}

	/**
	 * 列表
	 */
	@RequestMapping("/list/{catelogId}")
	public R list(@RequestParam Map<String, Object> params, @PathVariable("catelogId") Long catelogId) {
//        PageUtils page = attrGroupService.queryPage(params);
		PageUtils page = attrGroupService.queryPage(params, catelogId);

		return R.ok().put("page", page);
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{attrGroupId}")
	public R info(@PathVariable("attrGroupId") Long attrGroupId) {
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);

		Long catelogId = attrGroup.getCatelogId();
		Long[] path = categoryService.findCatelogPath(catelogId);
		attrGroup.setCatelogPath(path);
		return R.ok().put("attrGroup", attrGroup);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody AttrGroupEntity attrGroup) {
		attrGroupService.save(attrGroup);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody AttrGroupEntity attrGroup) {
		attrGroupService.updateById(attrGroup);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] attrGroupIds) {
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

		return R.ok();
	}

}
