package com.sms.api;

import com.sms.common.constant.Code;

import java.io.Serializable;

/**
 * @author chengxing
 * @date 2021/04/01
 * @param <T>
 */
public class ResponseMessage<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private T data;

    private int responseCode;

    private String description;

    private int total;

    public ResponseMessage(){}

    public ResponseMessage(T data) {
        this.data = data;
        this.responseCode = Code.SUCCESS.getCode();
        this.description = "SUCCESS";
    }

    public ResponseMessage(T data, int total) {
        this.data = data;
        this.responseCode = Code.SUCCESS.getCode();
        this.description = "SUCCESS";
        this.total = total;
    }

    public ResponseMessage(int code, T data) {
        this.data = data;
        this.responseCode = code;
        this.description = "SUCCESS";
    }

    public ResponseMessage(Code code) {
        this.data = null;
        this.responseCode = code.getCode();
        this.description = code.getDescription();
    }

    public ResponseMessage(Code code, T data) {
        this.data = data;
        this.responseCode = code.getCode();
        this.description = code.getDescription();
    }

    public ResponseMessage(Code code, String description, T data) {
        this.data = data;
        this.responseCode = code.getCode();
        this.description = description;
    }
    public ResponseMessage(int code, String description, T data) {
        this.data = data;
        this.responseCode = code;
        this.description = description;
    }


    public static <T> ResponseMessage success(T data) {
        return new ResponseMessage(data);
    }

    public static <T> ResponseMessage success(T data, int total) {
        return new ResponseMessage(data, total);
    }

    public static <T> ResponseMessage success(String description, T data) {
        return new ResponseMessage(Code.SUCCESS, description, data);
    }

    public static <T> ResponseMessage error(T data) {
        return new ResponseMessage(Code.FAIL, data);
    }

    public static <T> ResponseMessage loginError(T data) {
        return new ResponseMessage(Code.LOGIN_AUTH_FAIL, data);
    }

    public static <T> ResponseMessage error(int code, T data) {
        return new ResponseMessage(code, data);
    }

    public static <T> ResponseMessage error(Code code, T data) {
        return new ResponseMessage(code, data);
    }

    public static ResponseMessage error(int code, String description) {
        return new ResponseMessage(code, description, null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
