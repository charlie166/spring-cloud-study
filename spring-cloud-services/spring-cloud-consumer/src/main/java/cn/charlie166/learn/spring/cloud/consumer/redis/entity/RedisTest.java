package cn.charlie166.learn.spring.cloud.consumer.redis.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

/**
* @ClassName: RedisTest 
* @Description: redis测试用实体类
* @company 
* @author liyang
* @Email yang.li@rato360.com
* @date 2017年9月11日 
*
 */
@RedisHash(value = "redisTest", timeToLive = -1)
public class RedisTest{

	@Id
	private String id;
	@Indexed
	private String name;
	private String description;
	@Reference
	private List<RedisTest> list;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<RedisTest> getList() {
		return list;
	}
	public void setList(List<RedisTest> list) {
		this.list = list;
	}
	
}