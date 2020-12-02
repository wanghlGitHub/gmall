package com.atguigu.gmall.product.service.impl;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;
import com.atguigu.gmall.product.dao.SpuInfoDescDao;
import com.atguigu.gmall.product.entity.SpuInfoDescEntity;
import com.atguigu.gmall.product.service.SpuInfoDescService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * @author heliang.wang
 */
@Service("spuInfoDescService")
public class SpuInfoDescServiceImpl extends ServiceImpl<SpuInfoDescDao, SpuInfoDescEntity> implements SpuInfoDescService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuInfoDescEntity> page = this.page(
                new Query<SpuInfoDescEntity>().getPage(params),
				new QueryWrapper<>()
        );
        return new PageUtils(page);
    }

	@Override
	public void saveSpuInfoDesc(SpuInfoDescEntity descEntity) {
		this.baseMapper.insert(descEntity);
	}

}
