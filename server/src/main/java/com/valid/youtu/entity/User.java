package com.valid.youtu.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.valid.youtu.enums.Auth;

import java.util.Date;

@TableName("user")
public class User {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String userName;
    private String password;

    @TableField(fill = FieldFill.INSERT)
    private Auth auth; // 权限

    // 插入时更新
    @TableField(fill = FieldFill.INSERT)
    private Date createTime; // 创建时间

    @Version // 并发控制
    private Integer version;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String id, String userName, String password, Auth auth, Date createTime, Integer version) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.auth = auth;
        this.createTime = createTime;
        this.version = version;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Auth getAuth() {
        return auth;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Integer getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", auth=" + auth +
                ", createTime=" + createTime +
                ", version=" + version +
                '}';
    }
}