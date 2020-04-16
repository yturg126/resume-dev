package com.food.controller;


import com.food.pojo.Stu;
import com.food.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
public class HelloController {

    @Autowired
    private StuService stuService;


    @GetMapping("hello")
    public Object testHello() {
        return "Hello World ~ ";
    }


    @GetMapping("/getStu")
    public Stu getStu(int id) {
        return stuService.getStuInfo(id);
    }

    @PostMapping("/saveStu")
    public Object saveStu() {
        stuService.saveStu();
        return "ok";
    }

    @PostMapping("/deleteStu")
    public Object deletetu(int id) {
        stuService.deleteStu(id);
        return "ok";
    }

    @PostMapping("/updateStu")
    public Object updateStu(int id) {
        stuService.updateStu(id);
        return "ok";
    }

}
