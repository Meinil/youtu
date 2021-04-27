package com.valid.youtu.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestUUid {

    @DisplayName("测试UUID")
    @Test
    void test() {
        System.out.println(UUid.getUUID());
    }
}
