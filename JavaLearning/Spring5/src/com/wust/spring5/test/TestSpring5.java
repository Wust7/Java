package com.wust.spring5.test;

import com.wust.spring5.Orders;
import com.wust.spring5.bean.Emp;
import com.wust.spring5.collectiontype.Book;
import com.wust.spring5.collectiontype.Course;
import com.wust.spring5.collectiontype.Stu;
import com.wust.spring5.factorybean.MyBean;
import com.wust.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5 {
    @Test
    public void testAdd(){
        // 加载Spring的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        //获取配置创建的对象名
        Orders b = context.getBean("Orders", Orders.class);
        b.show();
    }

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);;
    }

    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");

//        Stu stu = context.getBean("stu", Stu.class);
//        System.out.println(stu);
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");

//        MyBean myBean = context.getBean("myBean", MyBean.class);
        //返回对象变为Course,因此改为Course --- FactoryBean
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
    }
    //验证bean默认是单实例
    @Test
    public void test5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");

        //单实例
//        Book book1 = context.getBean("book", Book.class);
//        Book book2 = context.getBean("book", Book.class);
        //多实例
        Book book1 = context.getBean("book2", Book.class);
        Book book2 = context.getBean("book2", Book.class);
        System.out.println(book1);
        System.out.println(book2);
    }

    @Test
    public void test6(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");

        com.wust.spring5.bean.Orders orders = context.getBean("orders", com.wust.spring5.bean.Orders.class);
        System.out.println("第四步  获取对象");
        System.out.println(orders);

        //手动让bean实例销毁
//        ((ClassPathXmlApplicationContext) context).close();
        context.close();
    }

    @Test
    public void test7(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean6.xml");
        Emp emp = context.getBean("emp3", Emp.class);
        System.out.println(emp);
    }
}
