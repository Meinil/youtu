package com.valid.youtu.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum Auth {
    ADMIN(0, "管理员"),
    VIP(1, "会员"),
    GENERAL(2, "普通用户");

    @EnumValue // 枚举自动映射
    private final Integer code;
    private final String msg;
    private Auth(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }
}
