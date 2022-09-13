package com.wust.demoproject.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//@RestControllerAdvice//标记该类为异常处理类，返回值为JSON数据
@ControllerAdvice//标记该类为异常处理类，返回值为ModelAndView数据
public class CustomExtHandler {

//    @ExceptionHandler(value = Exception.class)//指定异常
//    JsonData handlerException(Exception e, HttpServletRequest request){
//        return JsonData.buildError("服务端出问题了",-2);
//    }

    @ExceptionHandler(value = Exception.class)//指定异常
    ModelAndView handlerException(Exception e, HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        //properties中配置了静态资源加载路径，因而可以直接访问
        mv.setViewName("error.html");
        //将错误信息保存在公共域中，错误界面可以去公共域中取到该值
        mv.addObject("msg",e.getMessage());
        return mv;
    }
}
