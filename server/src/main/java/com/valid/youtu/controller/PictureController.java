package com.valid.youtu.controller;

import com.valid.youtu.service.PictureService;
import com.valid.youtu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @GetMapping("/{name}/{page}")
    public Result getPicture(@PathVariable("name") String name, @PathVariable("page") Integer page) {
        return pictureService.getPictureByPage(name, page);
    }


}
