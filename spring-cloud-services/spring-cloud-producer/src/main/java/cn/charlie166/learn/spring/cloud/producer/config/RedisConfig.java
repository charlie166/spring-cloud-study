package cn.charlie166.learn.spring.cloud.producer.config;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
* @ClassName: RedisConfig 
* @Description: redis配置类
* @company 
* @author liyang
* @Email charlie166@163.com
* @date 2017年10月30日 
*
 */
@Configuration
public class RedisConfig {

	@Autowired
	private RedisProperties redisProperties;

	@Bean
	public RedisConnectionFactory connectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setHostName(redisProperties.getHost());
		factory.setPort(redisProperties.getPort());
		factory.setTimeout(redisProperties.getTimeout());
		return factory;
	}

	@Bean
	public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<byte[], byte[]> template = new RedisTemplate<byte[], byte[]>();
		template.setKeySerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
		template.setConnectionFactory(connectionFactory);
		return template;
	}
}

