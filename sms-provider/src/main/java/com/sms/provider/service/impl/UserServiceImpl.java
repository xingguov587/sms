package com.sms.provider.service.impl;

import com.sms.api.pojo.User;
import com.sms.api.service.UserService;
import com.sms.api.vo.UserVo;
import com.sms.provider.dao.UserDao;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@DubboService
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer insert(User entity) {
        return userDao.insert(entity);
    }

    @Override
    public Integer insertBatch(List<User> entityList) {
        return userDao.insertBatch(entityList);
    }

    @Override
    public User selectById(Object id) {
        return userDao.selectById(id);
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public Integer deleteById(Object id) {
        return userDao.deleteById(id);
    }

    @Override
    public Integer update(User entity) {
        return userDao.update(entity);
    }

    @Override
    public List<User> list(User entity) {
        return userDao.list(entity);
    }

    @Override
    public List<User> getList(UserVo vo) {
        return userDao.getList(vo);
    }

    @Override
    public int count(UserVo vo) {
        return userDao.count(vo);
    }

    @Override
    public User getUserByName(String nickName) {
        return userDao.getUserByName(nickName);
    }

    @Override
    public User login(String sno, String password) {
        return userDao.login(sno,password);
    }
}
