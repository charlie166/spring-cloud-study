package cn.charlie166.learn.spring.cloud.producer.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import cn.charlie166.learn.spring.cloud.dto.attribute.CacheDaoAttribute;
import cn.charlie166.learn.spring.cloud.producer.domain.Demo;

/**
* @ClassName: DemoDao 
* @Description: 数据库演示接口
* @company 
* @author liyang
* @Email charlie166@163.com
* @date 2017年10月24日 
*
 */
public interface DemoDao {

	@CacheEvict(cacheNames = CacheDaoAttribute.DEMO_NAME, key = "'" + CacheDaoAttribute.DEMO_TOTAL_COUNT + "'")
	@Insert(value = "INSERT INTO demo(id, name, address) VALUES (#{id}, #{name}, #{address})")
	public int insertDemo(Demo demo);
	
	@Select(value = "SELECT MAX(id) FROM demo")
	public int selectMaxId();
	
	@Cacheable(cacheNames = CacheDaoAttribute.DEMO_NAME, key = "'" + CacheDaoAttribute.DEMO_TOTAL_COUNT + "'")
	public int selectCount();
}