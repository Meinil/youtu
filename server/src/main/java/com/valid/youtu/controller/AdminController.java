package com.valid.youtu.controller;

import com.valid.youtu.enums.Auth;
import com.valid.youtu.service.PictureService;
import com.valid.youtu.utils.RequiredToken;
import com.valid.youtu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PictureService pictureService;

    @RequiredToken(auth = Auth.ADMIN)
    @GetMapping("/{name}") // 总共的图片，包含未审批的
    public Result getAdminTotal(@PathVariable("name") String name) {
        return pictureService.getTotal(name, 2);
    }

    @RequiredToken(auth = Auth.ADMIN)
    @GetMapping("/{name}/{page}") // 分页查询图片，包含未审批
    public Result getAdminPicture(@PathVariable("name") String name, @PathVariable("page") Integer page) {
        return pictureService.getPictureByPage(name, page,2);
    }

    @RequiredToken(auth = Auth.ADMIN)
    @GetMapping("/examine/{name}") // 根据分类查询图片总数
    public Result getAdminExamineTotal(@PathVariable("name") String name) {
        return pictureService.getTotal(name, 2);
    }

    @RequiredToken(auth = Auth.ADMIN)
    @PostMapping("/update/{id}") // 审批某张图片
    public Result modifyPictureState(@PathVariable("id") String id) {
        return pictureService.modifyPictureState(id);
    }

    @RequiredToken(auth = Auth.ADMIN)
    @GetMapping("/examine/{name}/{page}") // 分页查询未审批的图片
    public Result getAdminExaminePicture(@PathVariable("name") String name, @PathVariable("page") Integer page) {
        return pictureService.getPictureByPage(name, page,0);
    }
}
