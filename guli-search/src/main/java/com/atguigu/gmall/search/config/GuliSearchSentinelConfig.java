package com.atguigu.gmall.search.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import com.alibaba.fastjson.JSON;
import com.atguigu.common.exception.BizCodeEnum;
import com.atguigu.common.utils.R;
import org.springframework.context.annotation.Configuration;

/**
 * @program: gmall
 * @description: es 常量类
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/7 10:23 上午
 * @Version: 1.0
 */
@Configuration
public class GuliSearchSentinelConfig {

    public GuliSearchSentinelConfig() {

        WebCallbackManager.setUrlBlockHandler((request, response, ex) -> {
			R error = R.error(BizCodeEnum.TOO_MANY_REQUEST.getCode(), BizCodeEnum.TOO_MANY_REQUEST.getMsg());
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().write(JSON.toJSONString(error));

		});

    }

}
