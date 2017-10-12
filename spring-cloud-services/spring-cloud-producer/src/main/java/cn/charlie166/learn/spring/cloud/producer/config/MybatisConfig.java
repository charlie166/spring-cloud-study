package cn.charlie166.learn.spring.cloud.producer.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;

import com.zaxxer.hikari.HikariDataSource;

/**
* @ClassName: MybatisConfig 
* @Description: Mybatis配置类
* @company 
* @author liyang
* @Email charlie166@163.com
* @date 2017年10月11日 
*
 */
@Configuration
public class MybatisConfig {

	@Value(value = "${jdbc.driver:}")
	private String driverClassName;
	@Value(value = "${jdbc.url}")
	private String jdbcUrl;
	@Value(value = "${jdbc.username}")
	private String username;
	@Value(value = "${jdbc.password}")
	private String password;
	
	@Bean
	public DataSource hikariDataSource(){
		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setJdbcUrl(jdbcUrl);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}
	
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean getSqlSessionFactoryBean(){
		SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
		fb.setDataSource(this.hikariDataSource());
		DefaultResourceLoader drl = new DefaultResourceLoader();
		fb.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		return fb;
	}
}