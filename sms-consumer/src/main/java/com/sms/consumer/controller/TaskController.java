package com.sms.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.sms.api.ResponseMessage;
import com.sms.api.dto.TaskDto;
import com.sms.api.pojo.Task;
import com.sms.api.pojo.UserTask;
import com.sms.api.service.TaskService;
import com.sms.api.service.UserTaskService;
import com.sms.api.vo.TaskVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("task")
@RestController
public class TaskController {

    @DubboReference
    TaskService taskService;

    @DubboReference
    UserTaskService userTaskService;

    @GetMapping("list")
    public ResponseMessage<List<TaskDto>> list(TaskVo vo){
        try {
            List<TaskDto> list = taskService.getList(vo);
            int count = taskService.count(vo);
            return ResponseMessage.success(list,count);
        }catch (Exception e){
            e.printStackTrace();
            log.error(JSONObject.toJSONString(vo));
            return ResponseMessage.error(500,"查询失败");
        }
    }

    /**
     * 老师发布作业
     * @param vo
     * @return
     */
    @PostMapping("publish")
    public ResponseMessage<Integer> publish(@RequestBody TaskVo vo){
        Task task = new Task();
        try {
            BeanUtils.copyProperties(vo,task);
            int row = taskService.insert(task);
            return ResponseMessage.success(row);
        }catch (Exception e){
            e.printStackTrace();
            log.error(JSONObject.toJSONString(vo));
            return ResponseMessage.error(500,"新增失败");
        }
    }

    /**
     * 学生上传作业
     * @param vo
     * @return
     */
    @PostMapping("upload")
    public ResponseMessage<Integer> upload(@RequestBody TaskVo vo){
        UserTask userTask = new UserTask();
        try {
            userTask.setTaskId(vo.getId());
            userTask.setUserId(vo.getCreator());
            userTask.setTaskUrl(vo.getStuTaskUrl());
            int row = userTaskService.insert(userTask);
            return ResponseMessage.success(row);
        }catch (Exception e){
            e.printStackTrace();
            log.error(JSONObject.toJSONString(vo));
            return ResponseMessage.error(500,"上传失败");
        }
    }

}
