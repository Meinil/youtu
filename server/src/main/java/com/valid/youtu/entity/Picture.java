package com.valid.youtu.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

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

    public Picture() {
    }

    public Picture(String id, String name, Date createTime, Classify classify) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.classify = classify;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setClassify(Classify classify) {
        this.classify = classify;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Classify getClassify() {
        return classify;
    }
}
