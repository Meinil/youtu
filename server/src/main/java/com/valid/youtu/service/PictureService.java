package com.valid.youtu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.valid.youtu.entity.Picture;
import com.valid.youtu.utils.Result;
import org.springframework.web.multipart.MultipartFile;

public interface PictureService extends IService<Picture> {
    Result getPictureByPage(String name, Integer pageNum);
    Result getTotal(String name);
    Result upload(MultipartFile file);
}
