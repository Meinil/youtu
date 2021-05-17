package com.valid.youtu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Classify {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String name;
}
