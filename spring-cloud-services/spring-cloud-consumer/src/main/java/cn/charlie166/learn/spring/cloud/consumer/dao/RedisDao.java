package cn.charlie166.learn.spring.cloud.consumer.dao;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * @description redis数据操作接口
 * @author <a href="mailto:charlie166@163.com">李阳</a> 
 * @version 1.0, 2017年9月10日
 * @see     
 * @since   spring-cloud-consumer 1.0
 */
public interface RedisDao {

	/**
	 * @description 保持数据到redis
	 * @author <a href="mailto:charlie166@163.com">李阳</a> 
	 * @param key 保持键值
	 * @param val  保持的值
	 * @since spring-cloud-consumer 1.0.0
	 */
	public void save(String key, Object val);
	
	/**
	 * @description 保存一个会过期的数据到redis
	 * @author <a href="mailto:charlie166@163.com">李阳</a> 
	 * @param key 保存的键值
	 * @param val 保持的数据
	 * @param timeout 超时时间
	 * @param timeunit  超时时间粒度
	 * @since spring-cloud-consumer 1.0.0
	 */
	public void save(String key, Object val, long timeout, TimeUnit timeunit);
	
	/**
	 * @description 获取指定键值数据
	 * @author <a href="mailto:charlie166@163.com">李阳</a> 
	 * @param key 返回数据
	 * @return 
	 * @since spring-cloud-consumer 1.0.0
	 */
	public Object get(String key);
	
	/**
	* @Title: getHash 
	* @Description: 获取hash对象
	* @param key
	* @param hashKey
	* @return
	 */
	public Object getHash(String key, String hashKey);
	
	/**
	* @Title: getTemplate 
	* @Description:
	* @return
	 */
	public RedisTemplate<String, Object> getTemplate();
}