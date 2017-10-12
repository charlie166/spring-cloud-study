package cn.charlie166.learn.spring.cloud.producer.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.charlie166.learn.spring.cloud.producer.service.inter.DemoService;

/**
* @ClassName: DemoServiceImpl 
* @Description: 演示服务接口实现类
* @company 
* @author liyang
* @Email charlie166@163.com
* @date 2017年10月11日 
*
 */
@Service
public class DemoServiceImpl implements DemoService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void testQuery() {
		try {
			PreparedStatement ps = dataSource.getConnection().prepareStatement("SELECT COUNT(id) FROM demo",
				ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = ps.executeQuery();
			if(rs.first()){
				logger.debug("结果:" + rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}