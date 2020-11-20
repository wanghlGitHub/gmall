package com.atguigu.gmall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gmall.ware.entity.PurchaseDetailEntity;

import java.util.Map;

/**
 * 
 *
 * @author heliang.wang
 * @email 568227120@qq.com
 * @date 2020-11-20 12:41:34
 */
public interface PurchaseDetailService extends IService<PurchaseDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

