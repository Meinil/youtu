package com.valid.youtu.enums;

/*
* 请求状态码
* */
public enum Code {
    OK(0, "请求成功"),
    NOT_AUTHORIZATION(1, "未授权"),
    NOT_FOUND(2, "未找到资源"),
    RESOURCE_CONFLICT(3, "资源冲突"),
    ERROR(4, "未知的错误");

    private int code; // 响应码编号
    private String msg; // 含义

    private Code(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + "";
    }
}
