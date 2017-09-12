package cn.charlie166.learn.spring.cloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.charlie166.learn.spring.cloud.consumer.redis.entity.RedisTest;
import cn.charlie166.learn.spring.cloud.consumer.service.RedisTestService;

/**
 * @description reids 测试控制器
 * @author <a href="mailto:charlie166@163.com">李阳</a> 
 * @version 1.0, 2017年9月10日
 * @see     
 * @since   spring-cloud-consumer 1.0
 */
@RequestMapping(value = "/test/redis")
@RestController
public class RedisTestController {

	@Autowired
	private RedisTestService redisService;
	
	/**
	 * @description
	 * @author <a href="mailto:charlie166@163.com">李阳</a> 
	 * @param key
	 * @param val
	 * @return 
	 * @since spring-cloud-consumer 1.0.0
	 */
	@RequestMapping(value = "/save/{key}")
	public Boolean saveOne(@PathVariable(value = "key") String key, @RequestBody Object val) {
		redisService.save(key, val);
		return Boolean.TRUE;
	}
	
	/**
	 * @description
	 * @author <a href="mailto:charlie166@163.com">李阳</a> 
	 * @param key
	 * @return 
	 * @since spring-cloud-consumer 1.0.0
	 */
	@RequestMapping(value = "/get/{key}")
	public Object getOne(@PathVariable(value = "key") String key) {
		return redisService.get(key);
	}
	
	/**
	* @Title: saveRef 
	* @Description: 保存关联关系
	* @param param
	* @return
	 */
	@RequestMapping(value = "/ref/save")
	public Object saveRef(@RequestBody RedisTest param){
		return redisService.saveRef(param);
	}
	
	/**
	* @Title: refById 
	* @Description: 通过ID查询
	* @param id
	* @return
	 */
	@RequestMapping(value = "/ref/get/{id}")
	public Object refById(@PathVariable(value = "id") String id){
		RedisTest rt = redisService.refById(id);
		return rt != null ? rt : "null";
	}
}