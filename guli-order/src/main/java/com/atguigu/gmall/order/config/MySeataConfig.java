package com.atguigu.gmall.order.config;

import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * @program: gmall
 * @description: 分布式事务 Seata 配置代理数据源
 * @Author: <a href="568227120@qq.com">heliang.wang</a>
 * @Date: 2021/1/11 1:19 下午
 * @Version: 1.0
 */
@Configuration
public class MySeataConfig {

	@Autowired
	DataSourceProperties dataSourceProperties;


	@Bean
	public DataSource dataSource(DataSourceProperties dataSourceProperties) {

		HikariDataSource dataSource = dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
		if (StringUtils.hasText(dataSourceProperties.getName())) {
			dataSource.setPoolName(dataSourceProperties.getName());
		}
		return new DataSourceProxy(dataSource);
	}
}
