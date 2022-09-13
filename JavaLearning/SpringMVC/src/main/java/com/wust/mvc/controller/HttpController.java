package com.wust.mvc.controller;

import com.wust.mvc.bean.User;
import org.springframework.core.io.support.ResourcePropertiesPersister;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
//@RestController //为一个复合注解，标识于控制器的类上，相当于为类添加了@Controller注解以及为每个方法添加了@ResponseBody注解
public class HttpController {

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println("requestBody:"+requestBody);
        return "success";
    }

    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        //当前requestEntiy来表示整个请求报文信息
        System.out.println("请求头:"+requestEntity.getHeaders());
        System.out.println("请求体："+requestEntity.getBody());
        return "success";
    }

    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        //放松数据给前端
        response.getWriter().print("hello,response");
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody//加上该注解后，方法返回值不再是视图名称，而是当前响应的响应体
    public String testResponseBody(){
        return "index.html";
    }

    @RequestMapping("/testResponseUser")
    @ResponseBody//加上该注解后，方法返回值不再是视图名称，而是当前响应的响应体
    public User testResponseUser(){
        User user = new User(1008, "admin", "1111", 23, "男", "wreqwer");
        //jackson可以将对象作为控制器方法的返回值返回，就会自动转换为json格式的字符串
        return user;
    }

    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username,String password){
        System.out.println(username+","+password);
        return "hello,axios";

    }
}
