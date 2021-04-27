package com.valid.youtu.utils;

import java.util.UUID;

public class UUid {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
