package com.sms.api.service;

import com.sms.api.dto.TaskDto;
import com.sms.api.pojo.Task;
import com.sms.api.vo.TaskVo;

import java.util.List;

public interface TaskService extends BaseService<Task>{

    List<TaskDto> getList(TaskVo vo);

    int count(TaskVo vo);
}
