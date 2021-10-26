package com.example.springbootinit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    //调用配置文件中的内容
    //对象注入
    @Value("${person.name}")
    private String name;

    @Value("${person.age}")
    private int age;

    //注入数组
    @Value("${address[0]}")
    private String address;

    @Value("${msg1}")
    private String msg1;

    @Value("${msg2}")
    private String msg2;

    //数据多时，Environment比较方便不用
    @Autowired
    private Environment env;

    @Autowired
    private person p;

    @RequestMapping("/JYQ")
    public String hello(){
//        System.out.println(age);
//        System.out.println(address);
//        System.out.println(msg1);
//        System.out.println(msg2);
//        System.out.println(address);
        System.out.println(env.getProperty("person.name"));
        System.out.println(p);
        return "Hello JYQ."+name;
    }
}
