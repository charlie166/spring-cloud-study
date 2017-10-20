package cn.charlie166.learn.spring.cloud.producer;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import cn.charlie166.learn.spring.cloud.producer.config.ControllerConfig;
import cn.charlie166.learn.spring.cloud.producer.config.MybatisConfig;
import cn.charlie166.learn.spring.cloud.producer.config.MybatisProp;
import cn.charlie166.learn.spring.cloud.producer.config.ServiceConfig;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(MybatisProp.class)
@Import(value = {MybatisConfig.class, ServiceConfig.class, ControllerConfig.class})
@ComponentScan(basePackages = {})
public class AppProducer {
	
    public static void main( String[] args ) {
    	SpringApplication.run(AppProducer.class, args);
    }
    
    @Bean
	public MapperScannerConfigurer scannerConfigurer(){
		MapperScannerConfigurer config = new MapperScannerConfigurer();
		config.setSqlSessionFactoryBeanName(MybatisConfig.SQL_SESSION_FACTORY_NAME);
		config.setBasePackage("cn.charlie166.learn.spring.cloud.producer.dao");
		return config;
	}
}
