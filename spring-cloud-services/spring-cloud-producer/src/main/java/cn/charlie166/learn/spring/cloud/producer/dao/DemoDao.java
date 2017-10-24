package cn.charlie166.learn.spring.cloud.producer.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

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

	@Insert(value = "INSERT INTO demo(id, name, address) VALUES (#{id}, #{name}, #{address})")
	public int insertDemo(Demo demo);
	
	@Select(value = "SELECT MAX(id) FROM demo")
	public int selectMaxId();
	
	public int selectCount();
}