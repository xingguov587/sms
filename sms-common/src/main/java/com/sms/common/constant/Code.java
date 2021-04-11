package com.sms.common.constant;

/**
 * @author chengxing
 * @date 2021/04/01
 */
public enum Code {

    SUCCESS(200,"操作成功"),
    PARAMATER(400,"参数错误"),
    LOGIN_AUTH_FAIL(401,"授权登录失败"),
    LOGIN_AUTH_OVERTIME(402,"登录超时"),
    PATH(404,"路径错误"),ADD_MACHINE(510,"添加失败"),
    SORT_DUPLICATED(511,"顺序重复"),
    FAIL(500,"请求失败"),
    NO_THIS_DATA(512,"没有这条数据"),
    VERSION_INCONSISTENCY(205,"版本不一致");

    private int code;

    private String description;

    Code(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
