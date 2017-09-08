package cn.charlie166.learn.spring.cloud.producer2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return "&lt;2&gt;hello " + name + "，this is second messge";
    }
}