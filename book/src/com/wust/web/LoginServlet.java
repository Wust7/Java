package com.wust.web;

import com.wust.pojo.User;
import com.wust.service.UserService;
import com.wust.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入Post");

        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //调用userService处理登陆业务
        User loginUser = userService.login(new User(null, username, password, null));

        if (loginUser==null){
            //把错误信息和回显得表单项信息，保存到Request域中
            req.setAttribute("msg","用户或密码错误！");
            req.setAttribute("username",username);

            //登陆失败,跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            //登录成功
            req.getRequestDispatcher("/pages/user/login_succcess.html").forward(req,resp);
        }
    }
}
