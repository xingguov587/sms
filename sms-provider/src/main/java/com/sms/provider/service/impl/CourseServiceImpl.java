package com.sms.provider.service.impl;

import com.sms.api.pojo.Course;
import com.sms.api.service.CourseService;
import com.sms.provider.dao.CourseDao;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@DubboService
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public Integer insert(Course entity) {
        return courseDao.insert(entity);
    }

    @Override
    public Integer insertBatch(List<Course> entityList) {
        return courseDao.insertBatch(entityList);
    }

    @Override
    public Course selectById(Object id) {
        return courseDao.selectById(id);
    }

    @Override
    public List<Course> selectAll() {
        return courseDao.selectAll();
    }

    @Override
    public Integer deleteById(Object id) {
        return courseDao.deleteById(id);
    }

    @Override
    public Integer update(Course entity) {
        return courseDao.update(entity);
    }

    @Override
    public List<Course> list(Course entity) {
        return courseDao.list(entity);
    }
}
