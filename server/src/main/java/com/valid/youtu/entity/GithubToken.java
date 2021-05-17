package com.valid.youtu.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "github")
public class GithubToken {
    @JSONField(name = "client_id")
    private String clientId;       // client_id

    @JSONField(name = "client_secret")
    private String clientSecret;   // client_secret

    @JSONField(name = "redirect_uri")
    private String redirectUri;    // 重定向的url

    private String code;            // code
    private String state;           // 状态

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class User{
        private String login;        // 账户
        private String avatarUrl;   // 头像
        private String bio;         // 用户名
    }
}
