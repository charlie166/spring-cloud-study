package cn.charlie166.learn.spring.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import cn.charlie166.learn.spring.cloud.consumer.config.RedisConfig;

@SpringBootApplication
@Import(value = RedisConfig.class)
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard
@EnableCircuitBreaker
@ComponentScan(basePackages = {"cn.charlie166.learn.spring.cloud.consumer.controller",
	"cn.charlie166.learn.spring.cloud.consumer.service",
	"cn.charlie166.learn.spring.cloud.consumer.dao",
	"cn.charlie166.learn.spring.cloud.consumer.remote"})
@EnableRedisRepositories(basePackages = {"cn.charlie166.learn.spring.cloud.consumer.redis.dao"})
public class AppConsumer {
	
    public static void main( String[] args ) {
    	SpringApplication.run(AppConsumer.class, args);
    }
}