package com.atguigu.gmall.search.service;

import com.atguigu.common.es.SkuEsModel;

import java.io.IOException;
import java.util.List;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/7 11:14 上午
 * @Version: 1.0
 */
public interface ProductSaveService {

    boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException;
}
