package com.wust.spring5.service;

import com.wust.spring5.dao.UserDao;
import com.wust.spring5.dao.UserDaoImpl;

public class UserService {
    private UserDao userDao;

    //创建UserDao类型属性，生成set方法
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("service add...");

//        //方式一：创建UserDao对象
//        UserDao user = new UserDaoImpl();
//        user.update();
        //方式二
        userDao.update();

    }

}
