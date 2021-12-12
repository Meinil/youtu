package com.valid.youtu.controller;

import com.valid.youtu.service.ClassifyService;
import com.valid.youtu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classify")
public class ClassifyController {

    @Autowired
    private ClassifyService service;

    @GetMapping("/total")
    public Result getTotal(){
        return service.getTotal();
    }
}
