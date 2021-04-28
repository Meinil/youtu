package com.valid.youtu.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum Auth {
    ADMIN(0, "管理员"),
    GENERAL(1, "普通用户"),
    VIP(2, "会员");

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
