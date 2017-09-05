package cn.ctw.spider.datasource;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * c3p0数据配置类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年8月18日 下午12:25:44
 * @version 1.0
 */
@Configuration
public class DataSourceConfiguration {
	
	@Bean("dataSource") // 定义一个Bean
	@Primary // 主要首选的Bean ,取代默认的bean
	@ConfigurationProperties(prefix="spring.datasource.c3p0")
	public DataSource getDataSource(){
		System.out.println("DataSourceConfiguration");
		return DataSourceBuilder.create()
				.type(ComboPooledDataSource.class).build();
	}
}
