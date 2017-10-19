package cn.charlie166.learn.spring.cloud.producer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
* @ClassName: ControllerConfig 
* @Description: 控制器配置类
* @company 
* @author liyang
* @Email charlie166@163.com
* @date 2017年10月19日 
*
 */
@Configuration
@ComponentScan(basePackages = {"cn.charlie166.learn.spring.cloud.producer.controller"})
public class ControllerConfig {

}