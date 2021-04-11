package com.sms.provider.service.impl;

import com.sms.api.pojo.GradeDim;
import com.sms.api.service.GradeDimService;
import com.sms.provider.dao.GradeDimDao;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@DubboService
public class GradeDimServiceImpl implements GradeDimService {

    @Autowired
    private GradeDimDao gradeDimDao;

    @Override
    public Integer insert(GradeDim entity) {
        return gradeDimDao.insert(entity);
    }

    @Override
    public Integer insertBatch(List<GradeDim> entityList) {
        return gradeDimDao.insertBatch(entityList);
    }

    @Override
    public GradeDim selectById(Object id) {
        return gradeDimDao.selectById(id);
    }

    @Override
    public List<GradeDim> selectAll() {
        return gradeDimDao.selectAll();
    }

    @Override
    public Integer deleteById(Object id) {
        return gradeDimDao.deleteById(id);
    }

    @Override
    public Integer update(GradeDim entity) {
        return gradeDimDao.update(entity);
    }

    @Override
    public List<GradeDim> list(GradeDim entity) {
        return gradeDimDao.list(entity);
    }
}
