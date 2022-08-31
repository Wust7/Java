package com.wust.test;

import java.lang.reflect.Method;

public class FunctionReflectTest {
    public void login(){
        System.out.println("login test");
    }
    public void regist(){
        System.out.println("regist test");
    }
    public void ship(){
        System.out.println("ship test");
    }

    public static void main(String[] args) {
        String action = "login";
        try {
            //通过反射获取反射对象
            Method method = FunctionReflectTest.class.getDeclaredMethod(action);
            System.out.println(method);
            //调用目标业务方法
            method.invoke(new FunctionReflectTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
