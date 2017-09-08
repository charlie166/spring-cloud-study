package cn.charlie166.learn.spring.cloud.consumer.remote.hystrix;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import cn.charlie166.learn.spring.cloud.consumer.remote.HelloRemote;
import cn.charlie166.learn.spring.cloud.dto.TestModelChild;

@Component
public class HelloRemoteHystrix implements HelloRemote{

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "&lt;Hystrix&gt;hello" + name + ", this messge send failed ";
    }

	@Override
	public Object contentConsumer(TestModelChild param) {
		String s = "method content(cn.charlie166.learn.spring.cloud.dto.TestModel param) failed";
		param.setDescription(s);
		return param;
	}
}