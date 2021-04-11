package com.sms.provider.dao;

import java.util.List;

/**
 * @param <T>
 * @author chengxing
 * 基类
 */
public interface BaseDao<T> {

    /**
     * 根据主键查询实体信息
     * @param id
     * @return
     */
    T selectById(Integer id);

    /**
     * 新增数据
     * @param entity
     * @return
     */
    Integer insert(T entity);

    /**
     * 批量新增
     * @param entityList
     * @return
     */
    Integer insertBatch(List<T> entityList);

    /**
     * 根据id查询实体信息
     * @param id
     * @return
     */
    T selectById(Object id);

    /**
     * 查询所有记录
     * @return
     */
    List<T> selectAll();

    /**
     * 根据id删除记录
     * @param id
     * @return
     */
    Integer deleteById(Object id);

    /**
     * 根据id更新实体属性
     * @param entity
     * @return
     */
    Integer update(T entity);

    /**
     * 根据属性查询列表
     * @param entity
     * @return
     */
    List<T> list(T entity);

}
