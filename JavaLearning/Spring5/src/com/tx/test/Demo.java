package com.tx.test;

import com.tx.config.TxConfig;
import com.tx.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.lang.Nullable;

public class Demo {
    @Nullable //可以使用在方法、属性、参数上，表示该方法返回值、属性值、参数可以为空
    private String name;


    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tx.xml");
        UserService userService = context.getBean("userService", UserService.class);
        Object[] args1 = {100,"JYQ"};
        Object[] args2 = {100,"WST"};
//        userService.accountMoney(args1,args2);
        userService.accountAndException(args1,args2);
    }

    //纯注解
    @Test
    public void test2(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        Object[] args1 = {100,"JYQ"};
        Object[] args2 = {100,"WST"};
//        userService.accountMoney(args1,args2);
        userService.accountAndException(args1,args2);
    }
}
