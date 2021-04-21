package com.sms.api.service;

import com.sms.api.pojo.User;
import com.sms.api.vo.UserVo;

import java.util.List;

public interface UserService extends BaseService<User>{

    List<User> getList(UserVo vo);

    int count(UserVo vo);

    User getUserByName(String nickName);

    User login(String sno,String password);
}
