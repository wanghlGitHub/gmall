package com.atguigu.gmall.search.controller;

import com.atguigu.gmall.search.service.MallSearchService;
import com.atguigu.gmall.search.vo.SearchParam;
import com.atguigu.gmall.search.vo.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: gmall
 * @description: 查询 controller
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/7 10:23 上午
 * @Version: 1.0
 */
public class SearchController {

	@Autowired
	private MallSearchService mallSearchService;

	/**
	 * 自动将页面提交过来的所有请求参数封装成我们指定的对象
	 *
	 * @param param
	 * @param model
	 * @param request
	 * @author: <a href="568227120@qq.com">heliang.wang</a>
	 * @date: 2020/12/7 10:23 上午
	 * @return: java.lang.String
	 */
	@GetMapping(value = "/list.html")
	public String listPage(SearchParam param, Model model, HttpServletRequest request) {

		param.set_queryString(request.getQueryString());

		//1、根据传递来的页面的查询参数，去es中检索商品
		SearchResult result = mallSearchService.search(param);

		model.addAttribute("result", result);

		return "list";
	}
}
