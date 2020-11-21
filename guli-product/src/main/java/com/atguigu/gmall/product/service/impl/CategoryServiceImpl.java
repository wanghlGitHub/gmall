package com.atguigu.gmall.product.service.impl;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;
import com.atguigu.gmall.product.dao.CategoryDao;
import com.atguigu.gmall.product.entity.CategoryEntity;
import com.atguigu.gmall.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		IPage<CategoryEntity> page = this.page(
				new Query<CategoryEntity>().getPage(params),
				new QueryWrapper<>()
		);

		return new PageUtils(page);
	}

	@Override
	public List<CategoryEntity> listWithTree() {
		//1、查出所有分类
		List<CategoryEntity> entities = baseMapper.selectList(null);
		//2、组装成父子的树形结构
		List<CategoryEntity> level1Menus = entities.stream().filter(categoryEntity -> categoryEntity.getParentCid() == 0
		).map((menu) -> {
			menu.setChildren(getChildrens(menu, entities));
			return menu;
		}).sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort()))).collect(Collectors.toList());
		return level1Menus;
	}

	@Override
	public Boolean removeMenuByIds(List<Long> asList) {
		//TODO  1、检查当前删除的菜单，是否被别的地方引用
		//逻辑删除
		baseMapper.deleteBatchIds(asList);
		return true;
	}

	/**
	 * 递归查找所有菜单的子菜单
	 *
	 * @param root
	 * @param all
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/11/21 4:05 下午
	 * @return: java.util.List<com.atguigu.gmall.product.entity.CategoryEntity>
	 */
	private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all) {

		List<CategoryEntity> children = all.stream().filter(categoryEntity -> categoryEntity.getParentCid().equals(root.getCatId())).map(categoryEntity -> {
			//1、找到子菜单
			categoryEntity.setChildren(getChildrens(categoryEntity, all));
			return categoryEntity;
		}).sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort()))).collect(Collectors.toList());

		return children;
	}
}
