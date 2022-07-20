package com.zhujie.spring5.testDemo;

import com.zhujie.spring5.config.SpringConfig;
import com.zhujie.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    /**
     * 基于xml的bean实现
     */
    @Test
    public void test(){
        ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("zhujie.xml");
        UserService userService = con.getBean("userService", UserService.class);
        userService.add();
    }

    /**
     * 基于纯注解的bean开发
     */
    @Test
    public void test2(){
        //加载配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}
