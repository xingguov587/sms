package com.sms.provider.dao;

import com.sms.api.pojo.User;
import com.sms.api.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao extends BaseDao<User>{

    List<User> getList(UserVo vo);

    int count(UserVo vo);

    User getUserByName(@Param("nickName") String nickName);
}