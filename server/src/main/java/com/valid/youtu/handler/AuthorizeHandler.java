package com.valid.youtu.handler;

import com.alibaba.fastjson.JSON;
import com.valid.youtu.entity.GithubToken;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthorizeHandler {
    @Autowired
    private GithubToken github;

    public GithubToken.User GithubAccessToken(String code, String state){
        MediaType mediaType= MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

        // 设置githubToken
        github.setCode(code);
        github.setState(state);
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(github));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            // 获取并解析AccessToken
            String accessToken = response.body().string();
            System.out.println(accessToken);
            String[] split = accessToken.split("&");
            accessToken = split[0].split("=")[1];
            return getUser(accessToken);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private GithubToken.User getUser(String accessToken){
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.github.com/user")
                    .addHeader("Authorization", "token " + accessToken)
                    .build();

            Response response = client.newCall(request).execute();
            // 解析user对象
            return JSON.parseObject(response.body().string(), GithubToken.User.class);//将string解析成GitHub对象
        } catch (IOException e) {
            return null;
        }
    }
}
