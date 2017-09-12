package cn.charlie166.learn.spring.cloud.consumer.service;

import cn.charlie166.learn.spring.cloud.consumer.redis.entity.RedisTest;

/**
 * @description redis测试服务接口
 * @author <a href="mailto:charlie166@163.com">李阳</a> 
 * @version 1.0, 2017年9月10日
 * @see     
 * @since   spring-cloud-consumer 1.0
 */
public interface RedisTestService {

	/**
	 * @description 保存数据到redis
	 * @author <a href="mailto:charlie166@163.com">李阳</a> 
	 * @param key 保持的键值
	 * @param val 保持的数据
	 * @since spring-cloud-consumer 1.0.0
	 */
	public void save(String key, Object val);
	
	/**
	 * @description 获取指定键值数据
	 * @author <a href="mailto:charlie166@163.com">李阳</a> 
	 * @param key 需要获取的键
	 * @return 
	 * @since spring-cloud-consumer 1.0.0
	 */
	public Object get(String key);
	
	/**
	* @Title: saveRef 
	* @Description: 保存关联数据到redis
	* @param redisTest 需要保存的数据
	* @return 
	 */
	public RedisTest saveRef(RedisTest redisTest);
	
	/**
	* @Title: refById 
	* @Description: 通过ID查询
	* @param id
	* @return
	 */
	public RedisTest refById(String id);
}