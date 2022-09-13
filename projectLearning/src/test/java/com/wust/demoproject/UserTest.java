package com.wust.demoproject;


import com.wust.demoproject.controller.UserController;
import com.wust.demoproject.domain.User;
import com.wust.demoproject.utils.JsonData;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


//单元测试
@RunWith(SpringRunner.class)//底层用junit SpringJUnit4ClassRunner
@SpringBootTest(classes = {DemoProjectApplication.class})//启动整个springboot工程
public class UserTest {

    @Autowired
    private UserController userController;

    @Test
    public void loginTest(){
        User user = new User();
        user.setUsername("w1");
        user.setPwd("1w");
        JsonData jsonData = userController.login(user);
        System.out.println(jsonData);
        TestCase.assertEquals(0,jsonData.getCode());
    }
}
