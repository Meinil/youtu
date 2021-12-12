package com.valid.youtu.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.valid.youtu.entity.Classify;
import com.valid.youtu.entity.Picture;
import com.valid.youtu.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
public class TestUserMapper {

    @Autowired
    private UserMapper userMapper;

    @DisplayName("测试数据库连接")
    @Test
    public void testConnect() {
        System.out.println("----- 测试数据库连接 ------");
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(1, userList.size());
        userList.forEach(System.out::println);
    }

    @DisplayName("测试插入和测试默认值")
    @Rollback(value = true)
    @Test
    public void testInsert() {
        System.out.println("----- 测试插入和测试默认值 ------");
        User user = new User();
        user.setUserName("asdf");
        user.setPassword("11wdfasdf");

        userMapper.insert(user);
    }
}
