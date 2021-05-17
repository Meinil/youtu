package com.valid.youtu.service;

import com.valid.youtu.entity.GithubToken;
import com.valid.youtu.utils.Result;

public interface AuthorizeService {
    Result crateUser(GithubToken.User user);
}
