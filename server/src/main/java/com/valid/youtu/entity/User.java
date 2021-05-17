package com.valid.youtu.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.valid.youtu.enums.Auth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
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
}