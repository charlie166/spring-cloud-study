package cn.charlie166.learn.spring.cloud.producer.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.charlie166.learn.spring.cloud.producer.tools.CustomKeyGenerator;

/**
* @ClassName: SpringCacheConfig 
* @Description: spring缓存配置类
* @company 
* @author liyang
* @Email charlie166@163.com
* @date 2017年10月25日 
*
 */
@Configuration
public class SpringCacheConfig {

	@Bean(name = "cacheManager")
	public CacheManager manager(){
		ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
		return cacheManager;
	}
	
	@Bean
	public KeyGenerator customKeyGenerator(){
		CustomKeyGenerator ckg = new CustomKeyGenerator();
		return ckg;
	}
}	