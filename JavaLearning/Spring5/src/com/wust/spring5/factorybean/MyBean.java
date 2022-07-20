package com.wust.spring5.factorybean;

import com.wust.spring5.collectiontype.Course;
import org.springframework.beans.factory.FactoryBean;
//定义MyBean对象，返回Course
public class MyBean implements FactoryBean<Course> {

    //定义返回bean
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setEname("abc");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
