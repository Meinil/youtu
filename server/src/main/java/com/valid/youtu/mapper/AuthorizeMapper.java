package com.valid.youtu.mapper;

import com.valid.youtu.entity.GithubToken;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthorizeMapper {
    @Insert("INSERT INTO user_auths(id, username, identity_type) VALUES (#{id}, #{login}, #{identityType})")
    Integer createAuthorUser(GithubToken.User user);
}
