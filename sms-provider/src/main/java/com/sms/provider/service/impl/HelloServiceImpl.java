package com.sms.provider.service.impl;

import com.sms.api.service.HelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@DubboService
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return name;
    }
}
