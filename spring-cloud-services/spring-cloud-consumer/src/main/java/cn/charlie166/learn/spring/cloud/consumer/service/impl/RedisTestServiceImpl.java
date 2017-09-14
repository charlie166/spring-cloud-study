package cn.charlie166.learn.spring.cloud.consumer.service.impl;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import cn.charlie166.learn.spring.cloud.consumer.dao.RedisDao;
import cn.charlie166.learn.spring.cloud.consumer.redis.dao.RedisTestDao;
import cn.charlie166.learn.spring.cloud.consumer.redis.entity.RedisTest;
import cn.charlie166.learn.spring.cloud.consumer.service.RedisTestService;

/**
 * @description redis操作测试服务接口实现类
 * @author <a href="mailto:charlie166@163.com">李阳</a> 
 * @version 1.0, 2017年9月10日
 * @see     
 * @since   spring-cloud-consumer 1.0
 */
@Service
public class RedisTestServiceImpl implements RedisTestService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RedisDao redisDao;
	@Autowired
	private RedisTestDao redisTestDao;
	
	@Override
	public void save(String key, Object val) {
		redisDao.save(key, val, 1, TimeUnit.MINUTES);
	}

	@Override
	public Object get(String key) {
		return StringUtils.isNotBlank(key) ? redisDao.get(key) : null;
	}

	@Override
	public RedisTest saveRef(RedisTest redisTest) {
		return redisTestDao.save(redisTest);
	}

	@Override
	public RedisTest refById(String id) {
		List<RedisTest> list = redisTestDao.name("混合");
		logger.debug("列表结果:" + list.size());
		RedisTemplate<String, Object> template = redisDao.getTemplate();
		HashOperations<String, Object, Object> opsForHash = template.opsForHash();
		RedisSerializer<?> hashKeySerializer = template.getHashKeySerializer();
		Object object = opsForHash.get("redisTest:a1", "name");
		logger.debug("获取对象:" + (object != null ? object.getClass().getName() : "null"));
		List<Object> values = opsForHash.values("test");
		if(values != null && !values.isEmpty()){
			for(Object obj : values){
				logger.debug("获取对象:" + (obj != null ? obj.getClass().getName() : "null"));
			}
		}
		return redisTestDao.findOne(id);
	}

}