package com.wust.demoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//无法扫描同层级以及上层，因而需要将扫描文件放在同层级子包内
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@ServletComponentScan//添加扫描组件
@EnableScheduling//开启定时任务，自动扫描
@EnableAsync//开启异步任务
public class DemoProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoProjectApplication.class,args);
    }
}
