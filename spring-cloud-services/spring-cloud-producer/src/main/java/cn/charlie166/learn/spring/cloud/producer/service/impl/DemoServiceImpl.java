package cn.charlie166.learn.spring.cloud.producer.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.charlie166.learn.spring.cloud.producer.dao.DemoDao;
import cn.charlie166.learn.spring.cloud.producer.domain.Demo;
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
	private DemoDao demoDao;
	
	@Override
	public void testQuery() {
		int lastId = demoDao.selectMaxId();
		logger.debug("当前条数before:" + demoDao.selectCount() + "----lastId:" + lastId);
		Demo newDemo = new Demo();
		newDemo.setId(++ lastId);
		newDemo.setName("名称" + lastId);
		newDemo.setAddress("地址:" + lastId);
		int result = demoDao.insertDemo(newDemo);
		logger.debug("新增结果:{}", result);
		logger.debug("当前条数before:" + demoDao.selectCount() + "----lastId:" + lastId);
		logger.debug("cache:" + demoDao.selectCount());
	}

}