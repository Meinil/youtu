package com.valid.youtu.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

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

    public GithubToken() {
    }

    public GithubToken(String clientId,
                       String clientSecret,
                       String code,
                       String redirectUri,
                       String state) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.code = code;
        this.redirectUri = redirectUri;
        this.state = state;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static class User{
        private String login;        // 账户
        private String avatarUrl;   // 头像
        private String bio;         // 用户名

        public User(String login,
                    String avatarUrl,
                    String bio) {
            this.login = login;
            this.avatarUrl = avatarUrl;
            this.bio = bio;
        }

        public User() {
        }

        public String getLogin() {
            return login;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public String getBio() {
            return bio;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }
    }
}
