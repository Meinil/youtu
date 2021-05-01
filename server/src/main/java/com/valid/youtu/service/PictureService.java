package com.valid.youtu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.valid.youtu.entity.Picture;
import com.valid.youtu.utils.Result;

public interface PictureService extends IService<Picture> {
    Result getPictureByPage(String name, Integer pageNum);
    Result getTotal(String name);
}
