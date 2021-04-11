package com.sms.consumer.controller;

import com.sms.api.ResponseMessage;
import com.sms.api.pojo.GradeDim;
import com.sms.api.service.GradeDimService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("gradeDim")
@RestController
public class GradeDimController {

    @DubboReference
    GradeDimService gradeDimService;

    @GetMapping("all")
    public ResponseMessage<List<GradeDim>> all(){
        try {
            List<GradeDim> list = gradeDimService.selectAll();
            return ResponseMessage.success(list);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseMessage.error(500,"查询失败");
        }
    }
}
