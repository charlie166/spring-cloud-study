package cn.charlie166.learn.spring.cloud.consumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @description redis配置类
 * @author <a href="mailto:charlie166@163.com">李阳</a> 
 * @version 1.0, 2017年9月10日
 * @see     
 * @since   spring-cloud-consumer 1.0
 */
@ConfigurationProperties
@Configuration
public class RedisConfig {

	@Value("${redis.hostname}")
	private String host;
	@Value("${redis.port}")
	private int port;
	@Value("${redis.pwd}")
	private String password;
	
	@Bean
	public RedisConnectionFactory jedisConnectionFactory(){
	   JedisPoolConfig poolConfig = new JedisPoolConfig();
	   poolConfig.setMaxIdle(5);
	   poolConfig.setMinIdle(1);
	   poolConfig.setTestOnBorrow(true);
	   poolConfig.setTestOnReturn(true);
	   poolConfig.setTestWhileIdle(true);
	   JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(poolConfig);
	   jedisConnectionFactory.setHostName(host);
	   jedisConnectionFactory.setPort(port);
	   jedisConnectionFactory.setPassword(password);
	   return jedisConnectionFactory;
	}
	 
	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory){
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        return template;
	}
}