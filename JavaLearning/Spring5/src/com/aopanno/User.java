package com.aopanno;


import org.springframework.stereotype.Component;

//2.创建对象
@Component
public class User {
    public void add(){
        System.out.println("add...");
    }
}
