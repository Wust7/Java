package com.wust.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1.先标记为控制类，后面再扫描才能成为bean来管理
@Controller
public class HelloController {
    //"/" --> /WEB-INF/templates/index.html --->/WEB-INF/templates/(前缀)+return index();+.html(后缀)
//    @RequestMapping(value = "/")//将方法index和请求"/"创建映射关系
    @RequestMapping("/")//只配置value属性时，value=可以省略
    public String index(){
        //返回视图名称
        return "index";
    }

//    第五步：进入控制器，将请求地址和RequestMapping注解的value属性值进行匹配，匹配成功，则会给返回值加上前后缀，将得到的路径返回给对应页面
    @RequestMapping("/target1")//与index.html中配置的target1相对应
    public String toTarget(){
        //返回视图名称
        return "target";
    }

//    @RequestMapping("/")//相同的路径只能有一个，否则会报错
//    public String index2(){
//        //返回视图名称
//        return "index";
//    }
}
