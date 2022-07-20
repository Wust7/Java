package com.aopanno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aopanno.xml");
        User user = context.getBean("user", User.class); //user -->User  默认首字母小写
        user.add();
    }
}
