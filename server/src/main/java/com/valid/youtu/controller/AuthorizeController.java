package com.valid.youtu.controller;

import com.valid.youtu.handler.AuthorizeHandler;
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

    @GetMapping("/github")
    public void github(@RequestParam String code,
                         @RequestParam String state,
                         HttpServletResponse response) throws IOException {
        System.out.println(authorize.GithubAccessToken(code, state));
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().println("<meta http-equiv=\"refresh\" content=\"0;url="+ FRONT_INDEX + "\">");
    }
}
