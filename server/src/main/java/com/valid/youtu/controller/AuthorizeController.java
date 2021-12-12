package com.valid.youtu.controller;

import com.valid.youtu.entity.GithubToken;
import com.valid.youtu.handler.AuthorizeHandler;
import com.valid.youtu.service.impl.AuthorizeServiceImpl;
import com.valid.youtu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/callback")
public class AuthorizeController {
    @Value("${front.index}")
    private String FRONT_INDEX;
    @Autowired
    private AuthorizeHandler authorize;
    @Autowired
    private AuthorizeServiceImpl service;
    @GetMapping("/github")
    public void github(@RequestParam String code,
                         @RequestParam String state,
                         HttpServletResponse response) throws IOException {
        GithubToken.User user = authorize.GithubAccessToken(code, state);
        user.setIdentityType("github");
        System.out.println(user);
        service.crateUser(user); // 创建用户

        response.setContentType("text/html; charset=utf-8");
        response.getWriter().println("<meta http-equiv=\"refresh\" content=\"0;url="+ FRONT_INDEX + "\">");
    }

    @GetMapping("/user")
    public Result user() {
        return null;
    }
}
