package cn.charlie166.learn.spring.cloud.consumer.redis.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cn.charlie166.learn.spring.cloud.consumer.redis.entity.RedisTest;

/**
* @ClassName: RedusTestDao 
* @Description: redis测试数据库接口
* @company 
* @author liyang
* @Email yang.li@rato360.com
* @date 2017年9月11日 
*
 */
public interface RedisTestDao extends CrudRepository<RedisTest, String>{

	/**
	* @Title: findByName 
	* @Description: 通过名称模糊查询
	* @param name 模糊查询关键字
	* @return 匹配的列表
	 */
	public List<RedisTest> findByName(String name);
}