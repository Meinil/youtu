package com.valid.youtu.service.impl;

import com.valid.youtu.entity.GithubToken;
import com.valid.youtu.mapper.AuthorizeMapper;
import com.valid.youtu.service.AuthorizeService;
import com.valid.youtu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeServiceImpl implements AuthorizeService {
    @Autowired
    private AuthorizeMapper mapper;

    @Override
    public Result crateUser(GithubToken.User user) {
        Result result = new Result();
        if (mapper.createAuthorUser(user) != 0) {
            result.setMsg("创建成功");
        }
        return result;
    }
}
