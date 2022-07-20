package com.aopanno;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)    //值越小优先级越高
public class PersonProxy {
    //UserProxy与PersonProxy都对User.add做增强，设置先后顺序
    @Before(value = "execution(* com.aopanno.User.add(..))")
    public void before(){
        System.out.println("Person before...");
    }
}
