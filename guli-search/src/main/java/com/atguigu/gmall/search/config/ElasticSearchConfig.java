package com.atguigu.gmall.search.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: gmall
 * @description: es 配置类
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2020/12/2 4:55 下午
 * @Version: 1.0
 */
@Configuration
public class ElasticSearchConfig {

	@Bean
	public RestHighLevelClient restHighLevelClient() {
		RestHighLevelClient client = new RestHighLevelClient(
				RestClient.builder(
						new HttpHost("localhost", 9200, "http")));

		return client;
	}
}
