package com.wust.demoproject.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//拦截器配置类
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addInterceptor:添加拦截器
        //addPathPatterns：配置拦截器路径
        registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/api/v1/pri/**");
        //将注册返回给父类
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    //创建登录拦截器
    @Bean
    public LoginInterceptor getLoginInterceptor(){
        return new LoginInterceptor();
    }
}
