package com.valid.youtu.file;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class TestFile {

    @DisplayName("文件路径测试")
    @Test
    public void testFile() throws FileNotFoundException {
        System.out.println(new File("").getAbsolutePath());
        System.out.println(ResourceUtils.getURL("classpath:").getPath());
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        System.out.println(path.getAbsolutePath());
    }
}
