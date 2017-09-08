package cn.charlie166.learn.spring.cloud.producer.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return "&lt;1&gt;hello " + name + "，this is first messge";
    }
	
	@RequestMapping(value = "/content", method = RequestMethod.POST)
	public Object contentConsumer(@RequestBody Object param){
		StringBuilder str = new StringBuilder();
		str.append("received msg:" + param.toString());
		str.append(" cls:" + param.getClass().getName());
		if(param != null && param instanceof Map){
			@SuppressWarnings("unchecked")
			Map<String, Object> m = (Map<String, Object>) param;
			m.put("description", str.toString());
			return m;
		}
		return param;
	}
}