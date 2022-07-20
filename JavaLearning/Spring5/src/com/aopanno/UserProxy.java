package com.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//增强类
@Component //2.创建对象
@Aspect  //3.生成代理对象
@Order(3)
public class UserProxy {

    //相同切入点抽取
    @Pointcut(value = "execution(* com.aopanno.User.add(..))")
    public void pointDemo(){}

    //前置通知
    //@Before注解表示作为前置通知
//    @Before(value = "execution(* com.aopanno.User.add(..))")  //4.配置前置通知
    @Before(value = "pointDemo()")  //4.配置前置通知
    public void before() {
        System.out.println("before...");
    }

    //最终通知：在方法执行之后执行 ，有异常也执行
    @After(value = "execution(* com.aopanno.User.add(..))")
    public void after() {
        System.out.println("after...");
    }

    //后置通知（返回通知）：在方法返回结果之后执行
    @AfterReturning(value = "execution(* com.aopanno.User.add(..))")
    public void afterReturning(){
        System.out.println("afterReturning...");
    }

    //异常通知  --有异常时才执行
    @AfterThrowing(value = "execution(* com.aopanno.User.add(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing...");
    }

    //环绕通知  -- 在增强的方法之前和之后都执行
    @Around(value = "execution(* com.aopanno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("环绕之前...");
        try {
            //被增强的方法
            proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("环绕之后...");

    }


}
