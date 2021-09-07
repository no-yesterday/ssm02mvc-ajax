package com.xiexin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 该 控制类 是为了查找jsp 或者 带参数访问 jsp 或者跳转
 */
@Controller
@RequestMapping("/pages")
public class PagesController {
    @RequestMapping("/reg")  //127.0.0.1:8080/pages/reg
    public String reg(){
        System.out.println("请求 进入 注册 了");
        return "reg";
    }

    @RequestMapping("/regForm")
    public String regForm(){
        return "regForm";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }

    @RequestMapping("/ajaxCommit")
    public String ajaxCommit(){
        return "ajaxCommit";
    }

    @RequestMapping("/ajaxBuy")
    public String ajaxBuy(){
        return "ajaxBuy";
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

}
