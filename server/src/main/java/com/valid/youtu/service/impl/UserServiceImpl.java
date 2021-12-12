package com.valid.youtu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.valid.youtu.entity.User;
import com.valid.youtu.mapper.UserMapper;
import com.valid.youtu.service.UserService;
import com.valid.youtu.utils.Result;
import com.valid.youtu.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper mapper;

    @Override
    public Result findUserByName(String username) {
        Result result = new Result(); // 返回结果
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", username);
        User user = mapper.selectOne(wrapper);

        if (user != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("user", user);
            result.setData(map);
        } else {
            result.setCode(Result.NOT_FOUND); // 未找到用户
        }
        return result;
    }

    // 注册
    @Override
    public Result register(User user) {

        Result result = new Result();
        try {
            mapper.insert(user);
            result.setMsg("创建用户成功");
            result.put("token", TokenUtil.getToken(user)); // 发放token
        } catch (Exception e) {
            result.setMsg("用户已经存在");
            result.setCode(Result.RESOURCE_CONFLICT);
        }

        return result;
    }

    // 登陆
    @Override
    public Result login(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", user.getUserName());
        wrapper.eq("password", user.getPassword());
        Result result = new Result();

        user = mapper.selectOne(wrapper);
        if (user == null) {
            result.setMsg("账号或者密码错误");
            result.setCode(Result.NOT_FOUND);
        } else {
            result.put("token", TokenUtil.getToken(user)); // 发放token
            System.out.println(user);
            result.put("avatarUrl", user.getAvatarUrl()); // 发放token
            result.setMsg("请求成功");
        }

        return result;
    }
}
