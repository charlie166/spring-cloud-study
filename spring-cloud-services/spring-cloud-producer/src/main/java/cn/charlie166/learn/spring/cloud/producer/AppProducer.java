package cn.charlie166.learn.spring.cloud.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import cn.charlie166.learn.spring.cloud.producer.config.MybatisConfig;

@SpringBootApplication
@EnableDiscoveryClient
@Import(value = {MybatisConfig.class})
@ComponentScan(basePackages = {"cn.charlie166.learn.spring.cloud.producer.controller", "cn.charlie166.learn.spring.cloud.producer.service"})
public class AppProducer {
	
    public static void main( String[] args ) {
    	SpringApplication.run(AppProducer.class, args);
    }
}