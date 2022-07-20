package com.zhujie.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  //作为配置类，替代xml文件
//开启组件扫描
//等价于<context:component-scan base-package="com.zhujie.spring5"></context:component-scan>
@ComponentScan(basePackages = "com.zhujie.spring5")
public class SpringConfig {
}
