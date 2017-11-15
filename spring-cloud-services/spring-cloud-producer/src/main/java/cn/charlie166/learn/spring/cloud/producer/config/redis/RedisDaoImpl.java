package cn.charlie166.learn.spring.cloud.producer.config.redis;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisDaoImpl implements RedisDao {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 
	 * @Title: getRedisTemplate 
	 * @Description: 获取RedisTemplate 
	 * @return RedisTemplate<String, Object>
	 */
	@Override
	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}
	
	/**
	 * 
	 * @Title: Hput 
	 * @Description: redis hash操作 存入map中一个值
	 * @param key hash的key
	 * @param field hash数据的key
	 * @param value hash数据的val
	 */
	@Override 
	public void hSet(String key, String field, Object value){
		logger.info("hSet-->key:" + key + "  field:" + field + "  value:" + value);
		redisTemplate.opsForHash().put(key, field, value);
	}
	
	/**
	 * 
	 * @Title: Hget 
	 * @Description: redis hash操作 取出map中一个值
	 * @param key hash的key
	 * @param field hash数据的key
	 * @return Object
	 */
	@Override 
	public Object hGet(String key, String field){
		logger.info("hGet-->key:" + key + "  field:" + field);
		return redisTemplate.opsForHash().get(key, field);

	}
	
	/**
	 * 
	 * @Title: hDel 
	 * @Description: 从hash表中删除一条数据
	 * @param key hash的key
	 * @param field hash数据的key
	 */
	@Override 
	public void hDel(String key,String field){
		logger.info("hDel-->key:" + key + "  field:" + field);
		redisTemplate.opsForHash().delete(key, field);
	}
	
	/**
	 * 
	 * @Title: del 
	 * @Description: 从redis db中删除指定key的数据
	 * @param key redis key
	 */
	@Override 
	public void del(String key){
		logger.info("del-->key:" + key);
		redisTemplate.delete(key);
	}
	
	/**
	 * 
	 * @Title: del 
	 * @Description: 从redis db中删除指定keys的数据
	 * @param keys  Collection<String>
	 */
	@Override 
	public void del(Collection<String> keys){
		logger.info("del-->keys:" + Arrays.toString(keys.toArray()));
		redisTemplate.delete(keys);
	}

	/**
	 * @Title: clear 
	 * @Description: 清空整个redis
	 * @return Object
	 */
	@Override 
	public Object clear(){
		logger.info("clear-->flushDb,flushAll。");
		return redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.flushDb(); 
				connection.flushAll();
				return connection;
			}
		});
	}
	
	/**
	 * 
	 * @Title: hLen 
	 * @Description: hash的size
	 * @param key hash的key
	 * @return
	 */
	@Override 
	public Long hSize(String key){
		logger.info("hSize-->key:" + key);
		return redisTemplate.opsForHash().size(key);
	}

	/**
	 * 
	 * @Title: expireBySeconds 
	 * @Description: 设置key的过期时间，以秒为单位
	 * @param key redis缓存key
	 * @param seconds 时间（秒）
	 * @return Boolean
	 */
	@Override 
	public Boolean expireBySeconds(String key, long seconds) {
		logger.info("expireBySeconds-->key:" + key + "  seconds:" + seconds);
		return redisTemplate.expire(key,seconds, TimeUnit.SECONDS);  
	}
	
	/**
	 * 
	 * @Title: expire 
	 * @Description: 设置key的过期时间，自定义时间类型及长度
	 * @param key redis缓存key
	 * @param timeout 时间
	 * @param unit 时间类型 如:TimeUnit.SECONDS
	 * @return Boolean
	 */
	@Override 
	public Boolean expire(String key, long timeout, TimeUnit unit) {
		logger.info("expire-->key:" + key + "  timeout:" + timeout + " unit:" + unit);
		return redisTemplate.expire(key, timeout, unit);
	}
	
	/**
	 * 
	 * @Title: persist 
	 * @Description: 取消key的过期时间设置
	 * @param key redis缓存key
	 * @return Boolean
	 */
	@Override 
	public Boolean persist(String key) {
		logger.info("persist-->key:" + key);
		return redisTemplate.persist(key);
	}
	
	/**
	 * 
	 * @Title: getExpire 
	 * @Description: 获取redis key的过期时间 
	 * @param unit 时间类型 如:TimeUnit.SECONDS
	 * @return
	 */
	@Override 
	public Long getExpire(String key, TimeUnit unit) {
		logger.info("getExpire-->key:" + key + " unit:" + unit);
		return redisTemplate.getExpire(key, unit);
	}
	
	/**
	 * 
	 * @Title: type 
	 * @Description: 获取key存储的类型
	 * @param key
	 * @return
	 */
	@Override 
	public DataType type(String key) {
		logger.info("type-->key:" + key);
		return redisTemplate.type(key);
	}
	
	/**
	 * 
	 * @Title: keys 
	 * @Description: 正则表达式匹配key
	 * @param pattern
	 * @return
	 */
	@Override 
	public Set<String> keys(String pattern) {
		logger.info("keys-->pattern:" + pattern);
		return redisTemplate.keys(pattern);
	}
	
	/**
	 * 
	 * @Title: setValForTimeout 
	 * @Description: 设置带有一个过期时间的key
	 * @param key  String
	 * @param value Object
	 * @param timeout long时间
	 * @param unit 用法 TimeUnit.
	 */
	@Override 
	public void setValForTimeout(String key, Object value, long timeout, TimeUnit unit) {
		logger.info("setValForTimeout-->key:" + key + " value:" + value + " timeout:" + timeout + " unit:" + unit);
		redisTemplate.opsForValue().set(key, value, timeout, unit);
	}
	
	/**
     * 
     * @Title: getValForTimeout 
     * @Description: 获取对应key的val
     * @param key
     * @return
     */
	@Override 
	public Object getValForTimeout(String key) {
		logger.info("getValForTimeout-->key:" + key);
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public void save(String key, Object value) {
		redisTemplate.opsForValue().set(key, value);
	}

}	