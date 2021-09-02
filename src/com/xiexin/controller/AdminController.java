package com.xiexin.controller;

import com.xiexin.bean.AdminInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/admin")
public class AdminController {
    //注册成功后，如果是单体项目---就要跳转到登录页，这个跳转是后台的转发 或 重定向
    //总之是，后台负责 跳转，携带数据的跳转页面的
    //如果是 新型的项目，即 前端向后端分离的，那么后台只负责，返回给前端json数据
    //跳转是 前端来处理的，前端根据 后台返回 code 代码，进行 跳转
    //如果前端负责跳转，他会起一个好听的名字，叫做 路由。

    //什么是前后端分离，即 项目上的分离 和 数据上的分离
    //项目上的分离： 前端一个项目，后台一个项目 2个项目
    //数据上的分离： 还是一个项目，只不过前后端 用json来交互数据
    //很少在用 jstl/el 表达式 来写项目。

    //layui 在 ssm/boot 框架的使用，其实是 数据上的分离，也可以项目上分离
    //那么他就是 json 交互的，那么后台只需要给他 返回json数据就可以了。

    //以前 在servlet 中，resp.getWriter().print(new JSONObject.toString(map))  。输出json
    //现在，我用mvc框架的，高级了。。

    //第一种收取参数方式: 数据类型接收参数！！
    @RequestMapping("/reg")  //layui 版本的
    @ResponseBody  //这个注解就是 返回给前端的json数据！！！
    public Map reg(String adminName,String adminPwd,String adminPwdR,String adminTime){
        System.out.println("adminPwdR = " + adminPwdR);
        System.out.println("adminTime = " + adminTime);
        Map codeMap = new HashMap();
        if (!adminPwd.equals(adminPwdR)) {
            codeMap.put("code","4401");
            codeMap.put("msg","你输入的密码和重复密码不一致，注册失败");
            return codeMap;
        }
        if (adminName.length() <= 0) {
            codeMap.put("code","4202");
            codeMap.put("msg","你的adminName填写完整");
            return codeMap;
        }
        if (adminPwd.length() <= 0) {
            codeMap.put("code","4202");
            codeMap.put("msg","你的adminPwd填写完整");
            return codeMap;
        }
        if (adminPwdR.length() <= 0) {
            codeMap.put("code","4202");
            codeMap.put("msg","你的adminPwdR填写完整");
            return codeMap;
        }
        codeMap.put("code","0");
        codeMap.put("msg","注册成功");
        return codeMap;
    }

    //传统版本的 不返回 json ，跳转使用转发或者重定向
    @RequestMapping("/regForm")
    public String regForm(String adminName,String adminPwd,String adminPwdR){
        System.out.println("adminName = " + adminName);
        System.out.println("adminPwd = " + adminPwd);
        //注册成功 跳转到登录页
        return "loginForm";
    }

    @RequestMapping("/regByBean")
    @ResponseBody
    public Map regByBean(AdminInfo adminInfo){
        System.out.println("adminInfo = " + adminInfo);
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","注册成功");
        return codeMap;
    }
}
