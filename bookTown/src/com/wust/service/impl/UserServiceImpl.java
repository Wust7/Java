package com.wust.service.impl;

import com.wust.dao.UserDao;
import com.wust.dao.impl.UserDaoImpl;
import com.wust.pojo.User;
import com.wust.service.UserService;

//第七步：业务层实现类
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if(userDao.queryUserByUsername(username) == null){
            return false;
        }
        return true;
    }
}
