package cn.charlie166.learn.spring.cloud.consumer.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.charlie166.learn.spring.cloud.consumer.remote.HelloRemote;
import cn.charlie166.learn.spring.cloud.dto.TestModelChild;

@RestController
public class ConsumerController {

	@Autowired
    private HelloRemote helloRemote;
	
    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return helloRemote.hello(name);
    }
    
    @RequestMapping(value = "/con", method = RequestMethod.POST)
    public Object content(@RequestBody TestModelChild param){
    	param.setList(Arrays.asList("a", "b", "c"));
    	return helloRemote.contentConsumer(param);
    }
}