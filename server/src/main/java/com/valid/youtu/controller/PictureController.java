package com.valid.youtu.controller;

import com.valid.youtu.service.PictureService;
import com.valid.youtu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @GetMapping("/picture/{name}")
    public Result getPicture(@PathVariable("name") String name) {
        return pictureService.getPicture(name);
    }
}