package com.valid.youtu.controller;

import com.valid.youtu.entity.GithubToken;
import com.valid.youtu.handler.AuthorizeHandler;
import com.valid.youtu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/callback")
public class AuthorizeController {
    @Autowired
    private AuthorizeHandler authorize;

    @GetMapping("/github")
    public Result github(@RequestParam String code,
                         @RequestParam String state) {
        System.out.println(authorize.GithubAccessToken(code, state));
        return new Result();
    }
}
