package com.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //JYQ给WST100元

    @Override
    public void addMoney(Object[] args) {
        String sql = "update account set money=money+? where username = ?";
        jdbcTemplate.update(sql,args);
    }

    @Override
    public void reduceMoney(Object[] args) {
        String sql = "update account set money=money-? where username = ?";
        jdbcTemplate.update(sql,args);
    }
}
