package cn.charlie166.learn.spring.cloud.consumer.service.impl;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
		return redisTestDao.findOne(id);
	}

}