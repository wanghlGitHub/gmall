package com.atguigu.gmall.gateway.config;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import com.alibaba.fastjson.JSON;
import com.atguigu.common.exception.BizCodeEnum;
import com.atguigu.common.utils.R;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @program: gmall
 * @description: sentinel 自定义流控响应
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/19 8:34 上午
 * @Version: 1.0
 */
@Configuration
public class SentinelGatewayConfig {

	public SentinelGatewayConfig() {
		//网关限流了请求，就会调用此回调
		GatewayCallbackManager.setBlockHandler((exchange, t) -> {

			R error = R.error(BizCodeEnum.TOO_MANY_REQUEST.getCode(), BizCodeEnum.TOO_MANY_REQUEST.getMsg());
			String errorJson = JSON.toJSONString(error);

			Mono<ServerResponse> body = ServerResponse.ok().body(Mono.just(errorJson), String.class);
			return body;
		});
	}
}
