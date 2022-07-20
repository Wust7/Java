package com.wust.spring5;

public class Orders {
    private String name;
    private int age;

    public Orders(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show(){
        System.out.println(name+","+age);
    }
}
