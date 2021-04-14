package com.sms.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.sms.api.ResponseMessage;
import com.sms.api.pojo.Course;
import com.sms.api.service.CourseService;
import com.sms.api.vo.CourseVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("course")
@RestController
public class CourseController {

    @DubboReference(timeout = 5000)
    CourseService courseService;

    /**
     * 新增课程
     * @param vo
     * @return
     */
    @PostMapping("add")
    public ResponseMessage<Integer> add(@RequestBody CourseVo vo){
        Course course = new Course();
        try {
            BeanUtils.copyProperties(vo,course);
            int row = courseService.insert(course);
            return ResponseMessage.success(row);
        }catch (Exception e){
            e.printStackTrace();
            log.error(JSONObject.toJSONString(vo));
            return ResponseMessage.error(500,"新增课程失败");
        }
    }

    /**
     * 修改课程
     * @param vo
     * @return
     */
    @PostMapping("update")
    public ResponseMessage<Integer> update(@RequestBody CourseVo vo){
        Course course = new Course();
        try {
            BeanUtils.copyProperties(vo,course);
            int row = courseService.update(course);
            return ResponseMessage.success(row);
        }catch (Exception e){
            e.printStackTrace();
            log.error(JSONObject.toJSONString(vo));
            return ResponseMessage.error(500,"修改课程失败");
        }
    }

    /**
     * 获取课程信息
     * @param id
     * @return
     */
    @GetMapping("getById")
    public ResponseMessage<Course> getById(Integer id){
        try {
            Course course = courseService.selectById(id);
            return ResponseMessage.success(course);
        }catch (Exception e){
            e.printStackTrace();
            log.error(String.valueOf(id));
            return ResponseMessage.error(500,"查询失败");
        }
    }

}
