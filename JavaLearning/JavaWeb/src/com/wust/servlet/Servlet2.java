package com.wust.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//用于测试请求转发:Servlet1和Servlet2共同完成一个业务
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数 （） ---相当于查看材料
        String username = req.getParameter("username");
        System.out.println("在Servlet2中查看参数:"+username);

        //查看柜台1是否盖章
        Object key1 = req.getAttribute("key1");
        System.out.println("Servlet1是否有确认章："+key1);

        //处理自己的业务
        System.out.println("处理Servlet2的业务");
    }
}
