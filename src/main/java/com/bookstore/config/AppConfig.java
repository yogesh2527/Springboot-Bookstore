package com.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = { "com.bookstore.service", "com.bookstore.dao" })
public class AppConfig {

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUsername("system");
		ds.setPassword("admin");
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521/XE");

		return ds;
	}

	@Bean(name = "jdbcTemplate")
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(dataSource());
		return jt;
	}

}
