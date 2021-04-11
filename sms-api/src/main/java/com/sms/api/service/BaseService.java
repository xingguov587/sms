package com.sms.api.service;

import java.util.List;

/**
 * @param <T>
 * @author chengxing
 * 基类
 */
public interface BaseService<T> {

    Integer insert(T entity);

    Integer insertBatch(List<T> entityList);

    T selectById(Object id);

    List<T> selectAll();

    Integer deleteById(Object id);

    Integer update(T entity);

    List<T> list(T entity);
}
