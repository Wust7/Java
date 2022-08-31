package com.wust.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//用于测试index.html跳转至该处
public class ForwardC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入ForwardC");
        /**
         * http://localhost:8080/JavaWeb/ForwardC跳转到
         * /a/b/c.html中../../index.html，而该地址是相对上面的地址的
         * 因而会跳转到http://localhost:8080/index.html---错误地址
         */
        req.getRequestDispatcher("/a/b/c.html").forward(req,resp);


    }
}
