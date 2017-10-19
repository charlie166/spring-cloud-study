package cn.charlie166.learn.spring.cloud.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import cn.charlie166.learn.spring.cloud.producer.config.ControllerConfig;
import cn.charlie166.learn.spring.cloud.producer.config.MybatisConfig;
import cn.charlie166.learn.spring.cloud.producer.config.MybatisProp;
import cn.charlie166.learn.spring.cloud.producer.config.ServiceConfig;

@SpringBootApplication
@EnableDiscoveryClient
@Import(value = {MybatisConfig.class, ServiceConfig.class, ControllerConfig.class})
@ComponentScan(basePackageClasses = {MybatisProp.class})
public class AppProducer {
	
    public static void main( String[] args ) {
    	SpringApplication.run(AppProducer.class, args);
    }
}