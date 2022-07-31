package com.tx.test;

import com.tx.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)//指定相关JUnit版本
//@ContextConfiguration("classpath:tx.xml") //加载配置文件
@SpringJUnitConfig(locations = "classpath:tx.xml") //上面两个等价于该注解
public class JTest4 {
    @Autowired
    private UserService userService; //由于上面注解加载了配置文件，因而可以直接得到UserService

    @Test
    public void test(){
        Object[] args1 = {100,"JYQ"};
        Object[] args2 = {100,"WST"};
        userService.accountMoney(args1,args2);
    }
}
