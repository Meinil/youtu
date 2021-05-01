package com.valid.youtu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.valid.youtu.entity.Picture;
import com.valid.youtu.mapper.PictureMapper;
import com.valid.youtu.service.PictureService;
import com.valid.youtu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture> implements PictureService {
    private static final Integer PAGE_NUM = 8; // 默认一页的大小

    private static String path; // 静态资源的路径

    @Resource
    private PictureMapper mapper;

    @Override
    public Result getPictureByPage(String name, Integer pageNum) {
        Result result = new Result();
        // 页数小于1,返回总页数
        if (pageNum < 1) {
            result.setCode(Result.NOT_FOUND);
            result.setMsg("查询失败");
            return result;
        }

        List<Picture> list = null;
        if (name.equals("recommend")) {
            list = mapper.getPicturesPages((pageNum - 1) * PAGE_NUM, PAGE_NUM);
            System.out.println(list.toString() + "=========");
        } else {
            String classify = getClassify(name);
            if (classify == null) {
                result.setCode(Result.ERROR);
                result.setMsg("错误的请求参数");
                return result;
            }

            list = mapper.getPicturesPagesByClassify((pageNum - 1) * PAGE_NUM, PAGE_NUM, classify);
        }
        list.forEach(picture -> {
            picture.setName(path + picture.getName());
        });
        result.put("pictures", list);
        result.setMsg("请求成功");
        return result;
    }

    // 获取某一分类的总数
    @Override
    public Result getTotal(String name) {
        Result result = new Result();
        String classify = getClassify(name);
        int count = 0;
        if (classify == null) {
            count = mapper.getTotal(true);
        } else {
            count = mapper.getTotalByClassify(classify, true);
        }
        result.put("total", count);
        result.setMsg("请求成功");
        return result;
    }

    // 分类转换
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

    @Value("${server.servlet.context-path}")
    public void setPath(String p) {
        path = p + "/res/picture/";
    }


}
