package com.atguigu.gmall.product.app;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;
import com.atguigu.gmall.product.entity.ProductAttrValueEntity;
import com.atguigu.gmall.product.service.AttrService;
import com.atguigu.gmall.product.service.ProductAttrValueService;
import com.atguigu.gmall.product.vo.AttrRespVo;
import com.atguigu.gmall.product.vo.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 商品属性
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:38:55
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {

	@Autowired
	private AttrService attrService;
	@Autowired
	ProductAttrValueService productAttrValueService;

	@GetMapping("/base/listforspu/{spuId}")
	public R baseAttrlistforspu(@PathVariable("spuId") Long spuId) {

		List<ProductAttrValueEntity> entities = productAttrValueService.baseAttrlistforspu(spuId);

		return R.ok().put("data", entities);
	}

	/**
	 * 查询列表数据
	 *
	 * @param params
	 * @param catelogId
	 * @param type
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/11/25 7:05 下午
	 * @return: com.atguigu.common.utils.R
	 */
	@GetMapping("/{attrType}/list/{catelogId}")
	public R baseAttrList(@RequestParam Map<String, Object> params,
						  @PathVariable("catelogId") Long catelogId,
						  @PathVariable("attrType") String type) {

		PageUtils page = attrService.queryBaseAttrPage(params, catelogId, type);
		return R.ok().put("page", page);
	}

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = attrService.queryPage(params);

		return R.ok().put("page", page);
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{attrId}")
	public R info(@PathVariable("attrId") Long attrId) {
		AttrRespVo respVo = attrService.getAttrInfo(attrId);

		return R.ok().put("attr", respVo);
	}

	/**
	 * 保存属性
	 *
	 * @param attr
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/11/25 7:04 下午
	 * @return: com.atguigu.common.utils.R
	 */
	@RequestMapping("/save")
	public R save(@RequestBody AttrVo attr) {
		attrService.saveAttr(attr);

		return R.ok();
	}


	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody AttrVo attr) {
		attrService.updateAttr(attr);

		return R.ok();
	}

	@PostMapping("/update/{spuId}")
	public R updateSpuAttr(@PathVariable("spuId") Long spuId,
						   @RequestBody List<ProductAttrValueEntity> entities) {

		productAttrValueService.updateSpuAttr(spuId, entities);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] attrIds) {
		attrService.removeByIds(Arrays.asList(attrIds));

		return R.ok();
	}

}
