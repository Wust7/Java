package com.zhujie.spring5.service;

import com.zhujie.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 在注解里面value属性值可以省略不写
 * 默认值是类名称，首字母小写  UserService -->userService
 */
@Component(value = "userService") //<bean id="userService class="...">
//@Service
public class UserService {

    //定义dao类型属性
    //不需要添加set方法
//    @Autowired //根据类型进行注入
//    @Qualifier(value = "userDaoImpl1") //一个接口有多个实现类，当不知道那个实现类来进行实例化时，可以用@Qualifier来指定实现类
//    private UserDao userDao; //直接通过类UserDaoImpl进行实例化

    //
//    @Resource //根据类型进行注入
//    private UserDao userDao;

    @Resource(name = "userDaoImpl1") //根据名称进行注入   -- 是javax中的，官方不建议使用
    private UserDao userDao;

    @Value(value = "abc") //将abc注入name中
    private String name;

    public void add(){
        System.out.println("service add...."+name);
        userDao.add();
    }
}
