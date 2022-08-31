package com.wust.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")//标记映射请求的请求路径的初始信息
public class RequestMappingController {

    @RequestMapping(
            value = {"/testRequestMapping","/test"},//标记映射请求的请求路径的具体信息,同时多个路径可以访问该请求映射
            method = {RequestMethod.GET,RequestMethod.POST},//设置请求方式，若请求方式不在列表中，则会报405的错误
            params = {"username"},// "username"表示必须携带username参数  "!username"表示不能携带username参数
            // "username=admin"表示必须携带username参数且参数值为admin "username!=admin"表示必须携带username参数且参数值不为admin 如果不满足上面条件的话会报400错误
            headers = {"Host=localhost:8082"}//表达式意思与上面差不多 不匹配则会报404错误
    )
    public String success() {
        return "success";
    }

    @GetMapping("/testGetMapping")
    public String testGetMapping(){
        return "success";
    }

    @RequestMapping(value = "/testPut",method = RequestMethod.PUT)
    public String testPut(){
        return "success";
    }

    @RequestMapping(value = "/testParamsAndHeaders",
            params = {"username"})
    public String testParamsAndHeaders(){
        return "success";
    }

    @RequestMapping(value = "/testHeaders",
            headers = {"Host=localhost:8080"})
    public String testHeaders(){
        return "success";
    }

//    @RequestMapping(value = "/a?a/testAnt")//模糊匹配 ? 表示占位符
//    @RequestMapping(value = "/a*a/testAnt")//* 表示0个或多个字符
    @RequestMapping(value = "/**/testAnt")//** 表示一层或多层目录 只能使用/**/xxx格式
    public String testAnt(){
        return "success";
    }

    @RequestMapping(value = "/testPath/{id}/{username}")//rest风格：id用于匹配路径中的值 ,若路径中没有id值则会报404错误
    public String testPath(@PathVariable("id")Integer id,@PathVariable("username")String username){//通过PathVariable将上面的id自动赋值给此处的id
        System.out.println("id:"+id+",username:"+username);
        return "success";
    }
}
