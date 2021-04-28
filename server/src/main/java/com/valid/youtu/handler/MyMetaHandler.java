package com.valid.youtu.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.valid.youtu.enums.Auth;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("auth", Auth.GENERAL, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
