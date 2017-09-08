package cn.charlie166.learn.spring.cloud.producer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "cn.charlie166.learn.spring.cloud.producer2.controller")
public class App {
	
    public static void main( String[] args ) {
    	SpringApplication.run(App.class, args);
//    	new SpringApplicationBuilder(App.class).web(true).run(args);
    }
}