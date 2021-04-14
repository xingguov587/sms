package com.sms.consumer.controller;

import com.sms.api.service.UserTaskService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("userTask")
@RestController
public class UserTaskController {

    @DubboReference(timeout = 5000)
    UserTaskService userTaskService;

}
