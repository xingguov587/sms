package com.sms.provider.service.impl;

import com.sms.api.dto.TaskDto;
import com.sms.api.pojo.Task;
import com.sms.api.service.TaskService;
import com.sms.api.vo.TaskVo;
import com.sms.provider.dao.TaskDao;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@DubboService
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public Integer insert(Task entity) {
        return taskDao.insert(entity);
    }

    @Override
    public Integer insertBatch(List<Task> entityList) {
        return taskDao.insertBatch(entityList);
    }

    @Override
    public Task selectById(Object id) {
        return taskDao.selectById(id);
    }

    @Override
    public List<Task> selectAll() {
        return taskDao.selectAll();
    }

    @Override
    public Integer deleteById(Object id) {
        return taskDao.deleteById(id);
    }

    @Override
    public Integer update(Task entity) {
        return taskDao.update(entity);
    }

    @Override
    public List<Task> list(Task entity) {
        return taskDao.list(entity);
    }

    @Override
    public List<TaskDto> getList(TaskVo vo) {
        return taskDao.getList(vo);
    }

    @Override
    public int count(TaskVo vo) {
        return taskDao.count(vo);
    }
}
