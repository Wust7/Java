package com.wust.demoproject.controller;

import com.wust.demoproject.config.WXConfig;
import com.wust.demoproject.task.AsyncTask;
import com.wust.demoproject.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

@RestController
@RequestMapping("api/v1/test")
@PropertySource("classpath:pay.properties")//注解配置文件
public class TestController {

    @Value("${wxpay.appid}")//从指定配置文件中取值
    private String payAppid;
    @Value("${wxpay.secret}")
    private String paySecret;

    @Autowired
    private WXConfig wxConfig;


    @GetMapping("list")
    public JsonData testExt(){
        int i = 1/0;
        return JsonData.buildSuccess("");
    }

    @GetMapping("get_config")
    public JsonData testConfig(){
        Map<String,String> map= new HashMap<>();
//        map.put("appid",payAppid);
//        map.put("paySecret",paySecret);
        map.put(wxConfig.getPayAppid(),wxConfig.getPaySecret());
        return JsonData.buildSuccess(map);
    }

    @Autowired
    private AsyncTask asyncTask;

    @GetMapping("async")
    public JsonData testAsync(){
        long begin = System.currentTimeMillis();
//        asyncTask.task1();
//        asyncTask.task2();
//        asyncTask.task3();

        Future<String> task4 = asyncTask.task4();
        Future<String> task5 = asyncTask.task5();

        long end = System.currentTimeMillis();
        return JsonData.buildSuccess(end-begin);
    }

}
