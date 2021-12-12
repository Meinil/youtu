package com.valid.youtu.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestUUID {
    @DisplayName("生成UUID")
    @Test
    public void testUUID() {
        System.out.println(UUIDUtil.getUUID());;
    }
}
