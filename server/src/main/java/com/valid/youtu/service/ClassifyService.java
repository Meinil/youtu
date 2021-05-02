package com.valid.youtu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.valid.youtu.entity.Classify;
import com.valid.youtu.utils.Result;

public interface ClassifyService extends IService<Classify> {
    Result getTotal();
}
