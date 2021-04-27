package com.valid.youtu.controller;

import com.valid.youtu.service.PictureServiceImpl;
import com.valid.youtu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PictureController {

    @Autowired
    private PictureServiceImpl pictureService;

    @GetMapping("/picture/{name}/{page}")
    public Result getPicture(@PathVariable("name") String name, @PathVariable("page") Integer page) {
        return pictureService.getPictureByPage(name, page);
    }
}
