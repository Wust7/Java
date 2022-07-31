package com.tx.service;

import com.tx.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
//@Transactional  //该注解可放在类、方法上，放在类上表示该类所有方法都添加事务，若方法在方法则为该方法添加事务
//@Transactional(propagation = Propagation.REQUIRED) //设置传播行为
//@Transactional(isolation = Isolation.REPEATABLE_READ) //隔离级别
//@Transactional(timeout = 5) //超时时间：事务需要在一定时间内提交，如果不提交则进行回滚，默认-1，单位：秒
//@Transactional(readOnly = false) //默认为false，表示可以CRUD（Create/read/update/delete），设置为true则只能查询
//@Transactional(rollbackFor = {NullPointerException.class, IOException.class}) //设置出现哪些异常进行事务回滚
//@Transactional(noRollbackFor = {NullPointerException.class, IOException.class}) //设置出现哪些异常不进行事务回滚
public class UserService {
    @Autowired
    private UserDao userDao;


    public void accountMoney(Object[] args1,Object[] args2){
        userDao.reduceMoney(args1);
        userDao.addMoney(args2);
    }

    public void accountAndException(Object[] args1,Object[] args2){
        userDao.reduceMoney(args1);
        int i = 10/0;
        userDao.addMoney(args2);
    }
}
