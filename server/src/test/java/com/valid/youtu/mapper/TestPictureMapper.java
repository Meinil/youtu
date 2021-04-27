package com.valid.youtu.mapper;

import com.valid.youtu.entity.Picture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestPictureMapper {

    @Autowired
    private PictureMapper pictureMapper;

    @DisplayName("测试连接查询")
    @Test
    public void testClassify() {
        List<Picture> comic = pictureMapper.getPicturesByClassify("生活");
        Assertions.assertEquals(0, comic.size());
    }
}
