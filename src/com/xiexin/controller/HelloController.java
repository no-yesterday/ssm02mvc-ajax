package com.xiexin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String Hello(){
        System.out.println("请求 进入 hello 了");
        return "rello";
    }

}
