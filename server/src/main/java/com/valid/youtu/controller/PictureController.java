package com.valid.youtu.controller;

import com.valid.youtu.entity.Picture;
import com.valid.youtu.enums.Auth;
import com.valid.youtu.service.PictureService;
import com.valid.youtu.utils.RequiredToken;
import com.valid.youtu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    // 分页查询
    @GetMapping("/{name}/{page}")
    public Result getPicture(@PathVariable("name") String name, @PathVariable("page") Integer page) {
        return pictureService.getPictureByPage(name, page, 1);
    }

    // 获取某一分类的总数
    @GetMapping("/{name}")
    public Result getTotal(@PathVariable("name") String name) {
        return pictureService.getTotal(name, 1);
    }

    @RequiredToken
    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file,
                         @RequestBody Picture picture)  {
        System.out.println(picture);
        return pictureService.upload(file);
    }
}
