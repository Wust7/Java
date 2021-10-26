package com.example.test;

import com.example.springboottest.SpringbootTestApplication;
import com.example.springboottest.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * userService的测试类
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootTestApplication.class)
public class UserServiceTest {
    //注解
    @Autowired
    private UserService userService;

    @Test
    public void testAdd(){
        userService.add();
    }
}
