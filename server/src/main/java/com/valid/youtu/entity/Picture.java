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

    @TableField(fill = FieldFill.INSERT)
    private Boolean isShow; // 是否显示

    private String owner; // 拥有者

    private String story; //图片描述信息

    public Picture() {
    }

    public Picture(String name, String owner, Classify classify) {
        this.name = name;
        this.owner = owner;
        this.classify = classify;
    }

    public Picture(String id,
                   String name,
                   Date createTime,
                   Classify classify,
                   Boolean isShow,
                   String owner,
                   String story) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.classify = classify;
        this.isShow = isShow;
        this.owner = owner;
        this.story = story;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public void setShow(Boolean show) {
        isShow = show;
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

    public String getOwner() {
        return owner;
    }

    public String getStory() {
        return story;
    }

    public Boolean getIsShow() {
        return isShow;
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
