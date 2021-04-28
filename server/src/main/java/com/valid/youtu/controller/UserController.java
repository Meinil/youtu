package com.valid.youtu.controller;

import com.valid.youtu.service.UserService;
import com.valid.youtu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@RequestParam("userName") String userName,
                           @RequestParam("password") String password) {
        return userService.register(userName, password);
    }
}
