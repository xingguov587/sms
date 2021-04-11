package com.sms.api.dto;

import com.sms.api.pojo.Task;

public class TaskDto extends Task {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
