package com.wust.mvc.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

//    当出现value值中的异常时就会跳转到下面方法
    @ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class})
    public String testException(Exception ex, Model model){//Exception 表示当前异常值
        //将exception放到请求域中
        model.addAttribute("ex",ex);
        return "error";
    }
}
