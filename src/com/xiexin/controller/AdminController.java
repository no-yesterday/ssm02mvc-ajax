package com.xiexin.controller;

import com.xiexin.bean.AdminInfo;
import com.xiexin.bean.Dog;
import com.xiexin.bean.Lover;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
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

    //ajax 接收 数据/集合
    @RequestMapping("/ajax03")
    @ResponseBody
    public Map ajax03(@RequestParam("ids[]") List<Integer> ids){
        for (Integer id : ids) {
            System.out.println("id = " + id);
        }
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","请求访问成功");
        codeMap.put("data",ids);
        return codeMap;
    }

    //ajax 接收 JSON 对象
    @RequestMapping("/ajax04")
    @ResponseBody
    public Map ajax04(@RequestBody AdminInfo adminInfo){
        System.out.println("adminInfo = " + adminInfo);
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","请求访问成功");
        codeMap.put("data",adminInfo);
        return codeMap;
    }

    //ajax 05 接收 前端传来的多个 对象
    @RequestMapping("/ajax05")
    @ResponseBody
    public Map ajax05(@ModelAttribute Lover lover,@ModelAttribute Dog dog){
        System.out.println("lover = " + lover);
        System.out.println("dog = " + dog);
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","请求访问成功");
        codeMap.put("data1",lover);
        codeMap.put("data2",dog);
        return codeMap;
    }
    //前端传来多个对象 需要根据请求的 前缀 进行绑定
    @InitBinder("lover")
    public void binding01(WebDataBinder webDataBinder){  //WebDataBinder 网络数据绑定
        webDataBinder.setFieldDefaultPrefix("lover.");
    }
    @InitBinder("dog")
    public void binding02(WebDataBinder webDataBinder){  //WebDataBinder 网络数据绑定
        webDataBinder.setFieldDefaultPrefix("dog.");
    }

    //ajax 06 接收 前端传来的多个 对象
    @RequestMapping("/ajax06")
    @ResponseBody      //  @GetMapping  和 @RequestBody  同时使用，等着被开除， 不可以同时存在，拿不到参数的
    public Map ajax06 (@RequestBody List<Lover> loverList){  //@RequestBody 这个注解他是方法体中拿取数据的，所以不能用Get请求！
        for (Lover lover : loverList) {
            System.out.println("lover = " + lover);
        }
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","请求访问成功");
        codeMap.put("data",loverList);
        return codeMap;
    }

    //ajax 07
    @RequestMapping("/ajax07")
    @ResponseBody   //十分常用， 还记得我门 servlet 多表的动态参数，就是用的map
    public Map ajax07(@RequestBody Map map){
        System.out.println("map的adminName = " + map.get("adminName"));
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","请求访问成功");
        codeMap.put("data",map);
        return codeMap;
    }

    //ajax 08
    @RequestMapping("/ajax08")
    @ResponseBody
    public Map ajax08(Lover lover, @RequestParam(value = "limit", required = false,defaultValue = "5")Integer pageSize,Integer page){
        System.out.println("lover = " + lover);
        System.out.println("pageSize = " + pageSize);
        System.out.println("page = " + page);
//        Map codeMap = new HashMap();
//        codeMap.put("code",0);
//        codeMap.put("msg","请求访问成功");
//        codeMap.put("data","");
//        return codeMap;
        return null;
    }

//    //ajaxBuy
//    @RequestMapping("/ajaxBuy")
//    @ResponseBody
//    public Map ajaxBuy(){
//        Map codeMap = new HashMap();
//        codeMap.put("code",0);
//        codeMap.put("msg","请求访问成功");
//        codeMap.put("data","");
//        return codeMap;
//    }

    //以上是前后端分离 最新项目 用到的知识点，那么也有 传统项目，后台负责跳到另一个界面

    //第一种 springMVC 的传值方式   原始方式： request + session + request 的转发
    //传统的MVC的方法（不返回json数据，不适用@ResponseBody），他要跳转jsp，跳转jsp的方式1，返回值是String
    //页面传值： 即 四大作用域 request  ，session  ，  application  ,  page...
    @RequestMapping("/yuansheng")  //什么是页面传值   登录页（admin,123456） -----》  yuansheng() -----》 （admin） home
//    public String yuansheng(AdminInfo adminInfo, HttpSession session){
    public String yuansheng(AdminInfo adminInfo, HttpServletRequest request){
        System.out.println("原生方式 页面赋值");
//        System.out.println("adminInfo = " + adminInfo);
        //登录  如果验证成功，那么就需要 把 登录信息 放入到session 域当中
//        session.setAttribute("adminInfo",adminInfo);
        String adminName = request.getParameter("adminName");
        String adminPwd = request.getParameter("adminPwd");
        request.setAttribute("adminName",adminName);
        request.setAttribute("adminPwd",adminPwd);
//        request.getRequestDispatcher("home.jsp").forward(request,response);  //servlet转发
        //servlet 的转发
//        return "home";   //这个 和 PagesController 中的 查找jsp的方法 没有关系。。
//        return "forward:/WEB-INF/pages/home.jsp";  //springMVC中的转发
//        return "forward:/pages/home";  //springMVC中的转发
        //重定向， servlet response.sendDirect("www.baidu.com")   重定向携带不了数据
//        return "redirect:https://www.baidu.com";  //不带 /  和 带 / 的区别
        return "redirect:/https://www.baidu.com";  //不带 /  和 带 / 的区别
    }

    //第二种 springMVC 的传值方式  modelAndView
    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView(AdminInfo adminInfo){
        //model 和 view 通俗，数据和显示  modelAndView 可以代替 转发功能 更强大了
        ModelAndView mv = new ModelAndView();
        mv.addObject("adminName",adminInfo.getAdminName());
        mv.addObject("adminPwd",adminInfo.getAdminPwd());
        System.out.println("以上是model 的绑定，即 数据的绑定");
        mv.setViewName("home");
        return mv;
    }

    //第三种 springMVC 的传值方式  model   代码量比较少
    @RequestMapping("/model")
    public String model(AdminInfo adminInfo, Model model){
        model.addAttribute("adminName",adminInfo.getAdminName());
        model.addAttribute("adminPwd",adminInfo.getAdminPwd());
        return "home";
    }

    //第四种 springMVC 的传值方式  modelMap
    @RequestMapping("/modelMap")
    public String modelMap(AdminInfo adminInfo, ModelMap modelMap){
        modelMap.put("adminName",adminInfo.getAdminName());
        modelMap.put("adminPwd",adminInfo.getAdminPwd());
        return "home";
    }

    //第五种 springMVC 的传值方式  map
    @RequestMapping("/map")
    public String map(AdminInfo adminInfo, Map<String, Object> map){
        map.put("adminName",adminInfo.getAdminName());
        map.put("adminPwd",adminInfo.getAdminPwd());
        return "home";
    }

}
