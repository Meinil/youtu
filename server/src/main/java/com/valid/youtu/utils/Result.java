package com.valid.youtu.utils;

import com.valid.youtu.enums.Code;

import java.util.Map;

/*
* 统一返回结果
* */
public class Result {
    private Code code; // 状态码
    private String msg; // 响应信息
    private Map<String, Object> data; // 响应数据

    public Result() {
        this.code = Code.OK; // 默认结果OK
    }

    public Result(Map<String, Object> data) {
        this();
        this.data = data;
    }

    public Result(Map<String, Object> data, String msg) {
        this(data);
        this.msg = msg;
    }

    public Result(Code code, Map<String, Object> data, String msg) {
        this(data, msg);
        this.code = code;
    }

    public Code getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
