package cn.charlie166.learn.spring.cloud.consumer.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.charlie166.learn.spring.cloud.consumer.remote.hystrix.HelloRemoteHystrix;
import cn.charlie166.learn.spring.cloud.dto.TestModelChild;

@FeignClient(name= "spring-cloud-producer", fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

	@RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name);
	
	@RequestMapping(value = "/content", method = RequestMethod.POST)
	public Object contentConsumer(@RequestBody TestModelChild param);
}