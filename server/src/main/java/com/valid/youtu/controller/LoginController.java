package com.valid.youtu.controller;

import com.valid.youtu.service.UserService;
import com.valid.youtu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestParam("username") String userName,
                        @RequestParam("password") String password) {
        return userService.login(userName, password);
    }
}
