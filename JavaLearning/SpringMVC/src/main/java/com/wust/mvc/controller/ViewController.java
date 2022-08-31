package com.wust.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/testTheymeleafView")
    public String testTheymeleafView(){
        return "success";//没有任何前缀因而会被Thymeleaf视图解析器解析，跳转方式为转发
    }

    /**
     * 转发：浏览器发送一次请求，第一次是浏览器发送，第二次是发送在服务器内部，因为第二次是发送是在服务器内部，
     * 所以地址栏地址不变，因而在如书本添加等操作时不能用转发，否则会刷新一次添加一本。
     * 转发可以获取request请求域中的数据，因为浏览器是一次请求所以请求域中的数据是同一个
     * 转发可以获取WEB-INF中的资源，因为WEB-INF中的数据具有安全性，只能通过服务器内部来访问不能通过浏览器访问，同时转发中存在的第二次发送发生在服务器内部，所以可以访问WEB-INF
     * 转发不能跨域（跨域：转发既然是发生在服务器内部的，因而其只能访问服务器内部资源，重定向是浏览器发送的请求，因而可以访问外部任何可访问资源）
     *
     * 重定向:浏览器发送两次请求，第一次访问servlet，第二次访问重定向地址，因为是浏览器发送了两次请求，所以浏览器地址会发生改变，所以可以用于书本添加等操作，刷新时不再响应该操作
     * 重定向不能获取request请求域中的数据，因为浏览器发送两次请求，两次请求对应两个request域数据，因而获取不到域中数据
     * 重定向不能获取WEB-INF中的资源，因为两次请求都发生在浏览器
     * 重定向可以跨域
     * @return
     */

    @RequestMapping("/testForward")
    public String testForward(){
        System.out.println("*********");
        //请求路径与Thymeleaf视图解析器中前后缀不对应时可以用forward
        return "forward:/testTheymeleafView";//添加有forward前缀表示请求转发,会被InternalResourceView视图解析器解析
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/testTheymeleafView";
    }

}
