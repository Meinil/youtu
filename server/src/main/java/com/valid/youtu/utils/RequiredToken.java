package com.valid.youtu.utils;

import com.valid.youtu.enums.Auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 需要验证TOKEN的接口注解
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredToken {
    Auth auth() default Auth.GENERAL; // 默认普通用户权限
}
