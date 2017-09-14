package cn.charlie166.learn.spring.cloud.consumer.dao.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import cn.charlie166.learn.spring.cloud.consumer.dao.RedisDao;

/**
 * @description redis操作实现类
 * @author <a href="mailto:charlie166@163.com">李阳</a> 
 * @version 1.0, 2017年9月10日
 * @see     
 * @since   spring-cloud-consumer 1.0
 */
@Repository
public class RedisDaoImpl implements RedisDao{

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public RedisTemplate<String, Object> getTemplate(){
		return this.redisTemplate;
	}
	
	@Override
	public void save(String key, Object val) {
		redisTemplate.opsForValue().set(key, val);
	}

	@Override
	public void save(String key, Object val, long timeout, TimeUnit timeunit) {
		redisTemplate.opsForValue().set(key, val, timeout, timeunit);
	}

	@Override
	public Object get(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public Object getHash(String key, String hashKey) {
		return redisTemplate.opsForHash().get(key, hashKey);
	}
	
}