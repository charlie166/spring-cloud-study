package cn.charlie166.learn.spring.cloud.producer.tools;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;

/**
* @ClassName: CustomKeyGenerator 
* @Description: 自定义键值生成器
* @company 
* @author liyang
* @Email charlie166@163.com
* @date 2017年10月25日 
*
 */
public class CustomKeyGenerator implements KeyGenerator {

	@Override
	public Object generate(Object target, Method method, Object... params) {
		return null;
	}

}