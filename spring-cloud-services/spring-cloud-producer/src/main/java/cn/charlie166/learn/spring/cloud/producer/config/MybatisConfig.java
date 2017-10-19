package cn.charlie166.learn.spring.cloud.producer.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

	/**sql会话工厂bean的名称**/
	public static final String SQL_SESSION_FACTORY_NAME = "sqlSessionFactory";
	
	@Bean
	public DataSource hikariDataSource(@Autowired MybatisProp prop){
		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName(prop.getDriverClassName());
		ds.setJdbcUrl(prop.getJdbcUrl());
		ds.setUsername(prop.getUsername());
		ds.setPassword(prop.getPassword());
		return ds;
	}
	
	@Bean(name = MybatisConfig.SQL_SESSION_FACTORY_NAME)
	public SqlSessionFactoryBean getSqlSessionFactoryBean(@Autowired MybatisProp prop){
		SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
		fb.setDataSource(this.hikariDataSource(prop));
		fb.setConfigLocation(prop.getConfigLocation());
		fb.setMapperLocations(prop.getMapperLocations());
		return fb;
	}
	
	@Bean
	public MapperScannerConfigurer scannerConfigurer(){
		MapperScannerConfigurer config = new MapperScannerConfigurer();
		config.setSqlSessionFactoryBeanName(MybatisConfig.SQL_SESSION_FACTORY_NAME);
		config.setBasePackage("cn.charlie166.learn.spring.cloud.producer.dao");
		return config;
	}
	
}