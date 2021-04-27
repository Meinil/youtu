package com.valid.youtu.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Map;

/*
* 统一返回结果
* */
public class Result {
    @JsonIgnore
    public static final int OK = 0; // 请求成功
    @JsonIgnore
    public static final int NOT_AUTHORIZATION = 1; // 未授权
    @JsonIgnore
    public static final int NOT_FOUND = 2; // 未找到资源
    @JsonIgnore
    public static final int RESOURCE_CONFLICT = 3; // 资源冲突
    @JsonIgnore
    public static final int ERROR = 4; // 未知的错误


    private int code; // 状态码
    private String msg; // 响应信息
    private Map<String, Object> data; // 响应数据

    public Result() {
        this.code = OK; // 默认结果OK
    }

    public Result(Map<String, Object> data) {
        this();
        this.data = data;
    }

    public Result(Map<String, Object> data, String msg) {
        this(data);
        this.msg = msg;
    }

    public Result(int code, Map<String, Object> data, String msg) {
        this(data, msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
