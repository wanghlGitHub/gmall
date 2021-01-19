package com.atguigu.gmall.order.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import com.alibaba.fastjson.JSON;
import com.atguigu.common.exception.BizCodeEnum;
import com.atguigu.common.utils.R;
import org.springframework.context.annotation.Configuration;

/**
 * @program: gmall
 * @description: sentinel 自定义流控响应
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/19 8:34 上午
 * @Version: 1.0
 */
@Configuration
public class GmallSentinelConfig {

	public GmallSentinelConfig() {
		WebCallbackManager.setUrlBlockHandler((request, response, e) -> {
			R error = R.error(BizCodeEnum.TOO_MANY_REQUEST.getCode(), BizCodeEnum.TOO_MANY_REQUEST.getMsg());
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print(JSON.toJSONString(error));
		});
	}
}
