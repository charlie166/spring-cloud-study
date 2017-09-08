package cn.charlie166.learn.spring.cloud.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "cn.charlie166.learn.spring.cloud.producer.controller")
public class AppProducer {
	
    public static void main( String[] args ) {
    	SpringApplication.run(AppProducer.class, args);
    }
}