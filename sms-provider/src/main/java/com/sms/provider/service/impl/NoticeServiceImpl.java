package com.sms.provider.service.impl;

import com.sms.api.pojo.Notice;
import com.sms.api.service.NoticeService;
import com.sms.provider.dao.NoticeDao;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@DubboService
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Override
    public Integer insert(Notice entity) {
        return noticeDao.insert(entity);
    }

    @Override
    public Integer insertBatch(List<Notice> entityList) {
        return noticeDao.insertBatch(entityList);
    }

    @Override
    public Notice selectById(Object id) {
        return noticeDao.selectById(id);
    }

    @Override
    public List<Notice> selectAll() {
        return noticeDao.selectAll();
    }

    @Override
    public Integer deleteById(Object id) {
        return noticeDao.deleteById(id);
    }

    @Override
    public Integer update(Notice entity) {
        return noticeDao.update(entity);
    }

    @Override
    public List<Notice> list(Notice entity) {
        return noticeDao.list(entity);
    }
}
