package cn.charlie166.learn.spring.cloud.producer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
* @ClassName: ServiceConfig 
* @Description: 服务相关配置信息
* @company 
* @author liyang
* @Email charlie166@163.com
* @date 2017年10月19日 
*
 */
@Configuration
@ComponentScan(basePackages = {"cn.charlie166.learn.spring.cloud.producer.service"})
public class ServiceConfig {

}	