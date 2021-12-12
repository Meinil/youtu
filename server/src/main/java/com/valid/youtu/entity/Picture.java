package com.valid.youtu.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("picture")
public class Picture {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String name;    // 图片名字

    // 插入时更新
    @TableField(fill = FieldFill.INSERT)
    private Date createTime; // 创建时间

    @JsonIgnore
    @TableField(exist = false)// 返回后端时忽略此字段
    private Classify classify; // 外键分类

    @TableField(fill = FieldFill.INSERT)
    private Boolean isShow; // 是否显示

    private String owner; // 拥有者

    private String story; //图片描述信息

    public Picture(String name, String owner, Classify classify) {
        this.name = name;
        this.owner = owner;
        this.classify = classify;
    }
}
