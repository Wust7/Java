package com.wust.demoproject.controller;

import com.wust.demoproject.config.WXConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("thymeleaf")
public class thymeleafController {

    @Autowired
    private WXConfig wxConfig;


    @GetMapping("test")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("setting",wxConfig);
        //不用加后缀应为properties配置文件已经加了识别的后缀.ftl
        return "tl/index";
    }
}
