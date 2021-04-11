package com.sms.provider.dao;

import com.sms.api.dto.TaskDto;
import com.sms.api.pojo.Task;
import com.sms.api.vo.TaskVo;

import java.util.List;

public interface TaskDao extends BaseDao<Task>{

    List<TaskDto> getList(TaskVo vo);

    int count(TaskVo vo);
}