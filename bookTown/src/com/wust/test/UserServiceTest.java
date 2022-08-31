package com.wust.test;

import com.wust.pojo.User;
import com.wust.service.UserService;
import com.wust.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"JYQ","JYQ","JYQ@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "JYQ", "JYQ", "JYQ@qq.com")));
    }

    @Test
    public void existUsername() {
        System.out.println(userService.existUsername("JYQ"));
    }
}