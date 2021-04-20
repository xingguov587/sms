package com.sms.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.sms.api.ResponseMessage;
import com.sms.api.pojo.User;
import com.sms.api.service.UserService;
import com.sms.api.vo.UserVo;
import com.sms.consumer.confg.Md5PasswordEncoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RequestMapping("user")
@RestController
public class UserController {

    @DubboReference(timeout = 5000)
    UserService userService;

    @GetMapping("/all")
    public ResponseMessage<List<User>> selectAll(){
        List<User> list = userService.selectAll();
        return ResponseMessage.success(list);
    }

    /**
     * 用户列表
     * @param vo
     * @return
     */
    @GetMapping("list")
    public ResponseMessage<List<User>> list(UserVo vo){
        try {
            List<User> list = userService.getList(vo);
            int count = userService.count(vo);
            return ResponseMessage.success(list,count);
        }catch (Exception e){
            e.printStackTrace();
            log.error(JSONObject.toJSONString(vo));
            return ResponseMessage.error(500,"查询失败");
        }
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PostMapping("update")
    public ResponseMessage<Integer> update(@RequestBody User user){
        try {
            int row = userService.update(user);
            return ResponseMessage.success(row);
        }catch (Exception e){
            e.printStackTrace();
            log.error(JSONObject.toJSONString(user));
            return ResponseMessage.error(500,"修改失败");
        }
    }

    /**
     * 登录
     * @param session
     * @param userName
     * @param password
     * @return
     */
    @GetMapping("login")
    public ResponseMessage<Integer> login(HttpSession session, String userName, String password){
        password = Md5PasswordEncoder.getInstance().encode(password);
        User user = userService.login(userName,password);
        if(user != null){
            session.setAttribute("loginUser",user);
            return ResponseMessage.success(1);
        }else {
            return ResponseMessage.error(401,"用户名密码错误");
        }
    }

    /**
     * 退出
     * @param session
     * @return
     */
    @GetMapping("logout")
    public ResponseMessage<Integer> logout(HttpSession session) {
        session.invalidate();
        return ResponseMessage.success(1);
    }



}
