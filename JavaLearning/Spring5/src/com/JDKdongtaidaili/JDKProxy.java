package com.JDKdongtaidaili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {
    public static void main(String[] args) {
        Class[] interfaces = {UserDao.class};
        /**
         * newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
         * ClassLoader loader :类加载器
         * Class<?>[] interfaces:增强方法所在的类，这个类实现的接口，支持多个接口
         * InvocationHandler h ： 实现这个接口InvocationHandler，创建代理对象，写增强的方法
         */
        //创建接口实现类代理对象
//        Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
//            //通过匿名内部类来实现
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        System.out.println(dao.add(1, 2));

    }
}
class UserDaoProxy implements InvocationHandler{

    //要增强的是UserDaoImpl类，在方法add和update的基础上添加一个方法
    //把创建的是谁的代理对象，把谁传递过来
    //有参构造传递
    private Object obj;
    public UserDaoProxy(Object obj) {
        this.obj=obj;
    }

    //增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在方法之前
        System.out.println("方法之前："+method.getName()+":传递参数..."+ Arrays.toString(args));

        //被增强的方法执行
        Object res = method.invoke(obj, args);

        //在方法之后
        System.out.println("方法之后:"+obj);
        return res;
    }
}
