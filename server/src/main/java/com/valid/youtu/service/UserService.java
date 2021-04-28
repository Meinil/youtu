package com.valid.youtu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.valid.youtu.entity.User;
import com.valid.youtu.utils.Result;

public interface UserService extends IService<User> {
    Result findUserByName(String username);
    Result register(String userName, String password);
    Result login(String username, String password);
}
