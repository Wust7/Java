package com.wust.demoproject.service;

import com.wust.demoproject.domain.User;

import java.util.List;


public interface UserService {
    String login(String username,String pwd);
    List<User> listUser();
}
