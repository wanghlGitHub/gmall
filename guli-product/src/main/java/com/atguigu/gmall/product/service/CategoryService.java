package com.atguigu.gmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gmall.product.entity.CategoryEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:38:55
 */
public interface CategoryService extends IService<CategoryEntity> {

	PageUtils queryPage(Map<String, Object> params);

	/**
	 * 商品分类树
	 *
	 * @param
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/11/21 4:00 下午
	 * @return: java.util.List<com.atguigu.gmall.product.entity.CategoryEntity>
	 */
	List<CategoryEntity> listWithTree();

	/**
	 * 删除商品分类
	 *
	 * @param asList
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/11/21 7:08 下午
	 * @return: java.lang.Boolean
	 */
	Boolean removeMenuByIds(List<Long> asList);

	/**
	 * 找到catelogId的完整路径；
	 * [父/子/孙]
	 *
	 * @param catelogId
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/11/25 3:04 下午
	 * @return: java.lang.Long[]
	 */
	Long[] findCatelogPath(Long catelogId);

	@Transactional
	void updateCascade(CategoryEntity category);
}

