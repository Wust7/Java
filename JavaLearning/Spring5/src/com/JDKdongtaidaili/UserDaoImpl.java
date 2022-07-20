package com.JDKdongtaidaili;

public class UserDaoImpl implements UserDao{

    @Override
    public int add(int a, int b) {
        System.out.println("UserDaoImpl add ...");
        return a+b;
    }

    @Override
    public String update(String id) {
        System.out.println("UserDaoImpl update ...");
        return id;
    }
}
