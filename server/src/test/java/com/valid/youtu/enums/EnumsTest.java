package com.valid.youtu.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EnumsTest {
    @DisplayName("测试enum")
    @Test
    public void testAuth() {
        System.out.println(Auth.ADMIN.getCode());
    }
}
