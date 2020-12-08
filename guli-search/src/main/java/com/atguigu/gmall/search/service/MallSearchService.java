package com.atguigu.gmall.search.service;

import com.atguigu.gmall.search.vo.SearchParam;
import com.atguigu.gmall.search.vo.SearchResult;

/**
 * @program: gmall
 * @description:
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/7 11:14 上午
 * @Version: 1.0
 */
public interface MallSearchService {

    /**
     * @param param 检索的所有参数
     * @return  返回检索的结果，里面包含页面需要的所有信息
     */
    SearchResult search(SearchParam param);
}
