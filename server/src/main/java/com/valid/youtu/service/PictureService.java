package com.valid.youtu.service;

import com.valid.youtu.entity.Picture;
import com.valid.youtu.enums.Code;
import com.valid.youtu.mapper.PictureMapper;
import com.valid.youtu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PictureService {
    @Autowired
    private PictureMapper pictureMapper;

    public Result getPicture(String name) {
        List<Picture> list = null;
        if (name.equals("recommend")) {
            // 分页查询
        }

        String classify = getClassify(name);
        if (classify == null) {
            return new Result(Code.ERROR, null, "错误的请求参数");
        }

        list = pictureMapper.getPicturesByClassify(classify);

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
