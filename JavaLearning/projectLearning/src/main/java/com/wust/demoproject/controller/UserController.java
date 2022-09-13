package com.wust.demoproject.controller;


import com.wust.demoproject.domain.User;
import com.wust.demoproject.service.UserService;
import com.wust.demoproject.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/pub/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @PostMapping("login")
//    public JsonData login(String username,String pwd){
//        System.out.println("Username:"+username+",Password:"+pwd);
//        return JsonData.buildSuccess("");
//    }

    @PostMapping("login")
    public JsonData login(@RequestBody User user){//加上@RequestBody后能处理JSON格式
        System.out.println("Username:"+user.getUsername()+",Password:"+user.getPwd());
        String token = userService.login(user.getUsername(), user.getPwd());
        return token!=null ? JsonData.buildSuccess(token):JsonData.buildError("账号密码错误");
    }

    /**
     * 列出全部用户
     * @return
     */
    @GetMapping("list")
    public JsonData listUser(){
        return JsonData.buildSuccess(userService.listUser());
    }
}
