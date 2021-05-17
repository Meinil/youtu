package com.valid.youtu.mapper;

import com.valid.youtu.entity.GithubToken;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthorizeMapperTest {
    @Autowired
    private AuthorizeMapper mapper;

    @Test
    @DisplayName("测试插入第三方用户")
    public void testCreateUser() {
        GithubToken.User user = new GithubToken.User();
        user.setLogin("hahahhah");
        user.setIdentityType("github");
        mapper.createAuthorUser(user);
    }
}
