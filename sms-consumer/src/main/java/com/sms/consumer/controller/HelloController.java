package com.sms.consumer.controller;

import com.sms.api.service.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("hello")
@RestController
public class HelloController {

    @DubboReference(timeout = 5000)
    HelloService helloService;

    @GetMapping("/test")
    public String Test(String name){
        return helloService.hello(name);
    }

}
