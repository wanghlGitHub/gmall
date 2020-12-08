package com.atguigu.gmall.product.service.impl;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;
import com.atguigu.gmall.product.dao.CategoryDao;
import com.atguigu.gmall.product.entity.CategoryEntity;
import com.atguigu.gmall.product.service.CategoryBrandRelationService;
import com.atguigu.gmall.product.service.CategoryService;
import com.atguigu.gmall.product.vo.Catelog2Vo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @author heliang.wang
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

	@Autowired
	CategoryBrandRelationService categoryBrandRelationService;

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

	@Override
	public Long[] findCatelogPath(Long catelogId) {
		List<Long> paths = new ArrayList<>();
		List<Long> parentPath = findParentPath(catelogId, paths);
		Collections.reverse(parentPath);

		return parentPath.toArray(new Long[parentPath.size()]);
	}

	/**
	 * 递归查找当前所有的父级路径
	 *
	 * @param catelogId
	 * @param paths
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/11/25 3:07 下午
	 * @return: java.util.List<java.lang.Long>
	 */
	private List<Long> findParentPath(Long catelogId, List<Long> paths) {
		//1、收集当前节点id
		paths.add(catelogId);
		CategoryEntity categoryEntity = this.getById(catelogId);
		if (categoryEntity.getParentCid() != 0) {
			findParentPath(categoryEntity.getParentCid(), paths);
		}
		return paths;
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

	/**
	 * 级联更新所有关联的数据
	 *
	 * @param category
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/11/25 3:35 下午
	 * @return: void
	 */
	@Transactional
	@Override
	public void updateCascade(CategoryEntity category) {
		this.updateById(category);
		categoryBrandRelationService.updateCategory(category.getCatId(), category.getName());
	}

	/**
	 * 每一个需要缓存的数据我们都来指定要放到那个名字的缓存。【缓存的分区(按照业务类型分)】
	 * 代表当前方法的结果需要缓存，如果缓存中有，方法都不用调用，如果缓存中没有，会调用方法。最后将方法的结果放入缓存
	 * 默认行为
	 * 如果缓存中有，方法不再调用
	 * key是默认生成的:缓存的名字::SimpleKey::[](自动生成key值)
	 * 缓存的value值，默认使用jdk序列化机制，将序列化的数据存到redis中
	 * 默认时间是 -1：
	 * <p>
	 * 自定义操作：key的生成
	 * 指定生成缓存的key：key属性指定，接收一个Spel
	 * 指定缓存的数据的存活时间:配置文档中修改存活时间
	 * 将数据保存为json格式
	 * <p>
	 * <p>
	 * 4、Spring-Cache的不足之处：
	 * 1）、读模式
	 * 缓存穿透：查询一个null数据。解决方案：缓存空数据
	 * 缓存击穿：大量并发进来同时查询一个正好过期的数据。解决方案：加锁 ? 默认是无加锁的;使用sync = true来解决击穿问题
	 * 缓存雪崩：大量的key同时过期。解决：加随机时间。加上过期时间
	 * 2)、写模式：（缓存与数据库一致）
	 * 1）、读写加锁。
	 * 2）、引入Canal,感知到MySQL的更新去更新Redis
	 * 3）、读多写多，直接去数据库查询就行
	 * <p>
	 * 总结：
	 * 常规数据（读多写少，即时性，一致性要求不高的数据，完全可以使用Spring-Cache）：写模式(只要缓存的数据有过期时间就足够了)
	 * 特殊数据：特殊设计
	 * <p>
	 * 原理：
	 * CacheManager(RedisCacheManager)->Cache(RedisCache)->Cache负责缓存的读写
	 *
	 * @return
	 */
	@Cacheable(value = {"category"}, key = "#root.method.name", sync = true)
	@Override
	public List<CategoryEntity> getLevel1Categorys() {
		System.out.println("getLevel1Categorys........");
		long l = System.currentTimeMillis();
		List<CategoryEntity> categoryEntities = this.baseMapper.selectList(
				new QueryWrapper<CategoryEntity>().eq("parent_cid", 0));
		System.out.println("消耗时间：" + (System.currentTimeMillis() - l));
		return categoryEntities;
	}

	@Cacheable(value = "category", key = "#root.methodName")
	@Override
	public Map<String, List<Catelog2Vo>> getCatalogJson() {
		System.out.println("查询了数据库");

		//将数据库的多次查询变为一次
		List<CategoryEntity> selectList = this.baseMapper.selectList(null);

		//1、查出所有分类
		//1、1）查出所有一级分类
		List<CategoryEntity> level1Categorys = getParent_cid(selectList, 0L);

		//封装数据
		Map<String, List<Catelog2Vo>> parentCid = level1Categorys.stream().collect(Collectors.toMap(k -> k.getCatId().toString(), v -> {
			//1、每一个的一级分类,查到这个一级分类的二级分类
			List<CategoryEntity> categoryEntities = getParent_cid(selectList, v.getCatId());

			//2、封装上面的结果
			List<Catelog2Vo> catelog2Vos = null;
			if (categoryEntities != null) {
				catelog2Vos = categoryEntities.stream().map(l2 -> {
					Catelog2Vo catelog2Vo = new Catelog2Vo(v.getCatId().toString(), null, l2.getCatId().toString(), l2.getName().toString());

					//1、找当前二级分类的三级分类封装成vo
					List<CategoryEntity> level3Catelog = getParent_cid(selectList, l2.getCatId());

					if (level3Catelog != null) {
						List<Catelog2Vo.Category3Vo> category3Vos = level3Catelog.stream().map(l3 -> {
							//2、封装成指定格式
							Catelog2Vo.Category3Vo category3Vo = new Catelog2Vo.Category3Vo(l2.getCatId().toString(), l3.getCatId().toString(), l3.getName());

							return category3Vo;
						}).collect(Collectors.toList());
						catelog2Vo.setCatalog3List(category3Vos);
					}

					return catelog2Vo;
				}).collect(Collectors.toList());
			}

			return catelog2Vos;
		}));

		return parentCid;
	}

	private List<CategoryEntity> getParent_cid(List<CategoryEntity> selectList, Long parentCid) {
		List<CategoryEntity> categoryEntities = selectList.stream().filter(item -> item.getParentCid().equals(parentCid)).collect(Collectors.toList());
		return categoryEntities;
		// return this.baseMapper.selectList(
		//         new QueryWrapper<CategoryEntity>().eq("parent_cid", parentCid));
	}
}
