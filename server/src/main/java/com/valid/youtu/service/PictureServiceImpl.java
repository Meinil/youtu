package com.valid.youtu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.valid.youtu.entity.Picture;
import com.valid.youtu.mapper.PictureMapper;
import com.valid.youtu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PictureServiceImpl {
    private static final Integer PAGE_NUM = 8;
    @Autowired
    private PictureMapper pictureMapper;

    public Result getPictureByPage(String name, Integer pageNum) {
        // 页数不能小于1
        if (pageNum < 1) return new Result(Result.ERROR, null, "错误的请求参数");

        List<Picture> list = null;
        Page<Picture> page = new Page<>((pageNum - 1) * PAGE_NUM, PAGE_NUM);
        if (name.equals("recommend")) {
            pictureMapper.selectPage(page, null);
            list = page.getRecords();
        } else {
            String classify = getClassify(name);
            if (classify == null) {
                return new Result(Result.ERROR, null, "错误的请求参数");
            }

            list = pictureMapper.getPicturesByClassify(page, classify).getRecords();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("pictures", list);
        return new Result(map, "请求成功");
    }

    private String getClassify(String name) {
        switch (name) {
            case "comic":
                return "动漫";
            case "scenery":
                return "风景";
            case "life":
                return "生活";
        }
        return null;
    }
}
