package com.sms.provider.service.impl;

import com.sms.api.pojo.UserTask;
import com.sms.api.service.UserTaskService;
import com.sms.provider.dao.UserTaskDao;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@DubboService
public class UserTaskServiceImpl implements UserTaskService {

    @Autowired
    private UserTaskDao userTaskDao;

    @Override
    public Integer insert(UserTask entity) {
        return userTaskDao.insert(entity);
    }

    @Override
    public Integer insertBatch(List<UserTask> entityList) {
        return userTaskDao.insertBatch(entityList);
    }

    @Override
    public UserTask selectById(Object id) {
        return userTaskDao.selectById(id);
    }

    @Override
    public List<UserTask> selectAll() {
        return userTaskDao.selectAll();
    }

    @Override
    public Integer deleteById(Object id) {
        return userTaskDao.deleteById(id);
    }

    @Override
    public Integer update(UserTask entity) {
        return userTaskDao.update(entity);
    }

    @Override
    public List<UserTask> list(UserTask entity) {
        return userTaskDao.list(entity);
    }
}
