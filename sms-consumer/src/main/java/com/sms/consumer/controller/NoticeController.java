package com.sms.consumer.controller;

import com.sms.api.service.NoticeService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("notice")
@RestController
public class NoticeController {

    @DubboReference
    NoticeService noticeService;

}
