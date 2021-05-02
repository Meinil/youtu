package com.valid.youtu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.valid.youtu.entity.Classify;
import com.valid.youtu.mapper.ClassifyMapper;
import com.valid.youtu.service.ClassifyService;
import com.valid.youtu.utils.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, Classify> implements ClassifyService {

    @Resource
    private ClassifyMapper mapper;

    @Override
    public Result getTotal() {
        Result result = new Result();
        result.put("classify", mapper.selectList(null));
        return result;
    }
}
