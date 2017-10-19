package cn.charlie166.learn.spring.cloud.producer.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
* @ClassName: MybatisProp 
* @Description: Mybatis属性配置类
* @company 
* @author liyang
* @Email charlie166@163.com
* @date 2017年10月19日 
*
 */
@ConfigurationProperties(prefix = "jdbc")
@Component
public class MybatisProp {

	@Value(value = "${jdbc.driver:}")
	private String driverClassName;
	@Value(value = "${jdbc.url}")
	private String jdbcUrl;
	private String username;
	private String password;
	@Value(value = "classpath:mybatis-config.xml")
	private Resource configLocation;
	@Value(value = "classpath:config/mapper/*.xml")
	private Resource[] mapperLocations;
	
	public String getDriverClassName() {
		return driverClassName;
	}
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Resource getConfigLocation() {
		return configLocation;
	}
	public void setConfigLocation(Resource configLocation) {
		this.configLocation = configLocation;
	}
	public Resource[] getMapperLocations() {
		return mapperLocations;
	}
	public void setMapperLocations(Resource[] mapperLocations) {
		this.mapperLocations = mapperLocations;
	}
	
	@PostConstruct
	public void postCon(){
		System.out.println("post of mybatis prop ....................");
	}
	
}	