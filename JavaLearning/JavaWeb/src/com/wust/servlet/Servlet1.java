package com.wust.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//用于测试请求转发
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数 （） ---相当于查看材料
        String username = req.getParameter("username");
        System.out.println("在Servlet1中查看参数:"+username);

        //通过域参数将数据传送给Servlet2  ---相当于盖章
        req.setAttribute("key1","Servlet1的确认章");

        //相当于问路
        //请求转发必须要以 斜杠/ 开头  表示地址为：http://ip:port/工程名/，映射到IDEA代码的web目录
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Servlet2");

        //请求转发可以转发到WEB-INF目录下   --用于测试请求转发可以访问受保护的WEB-INF/lib/form.html
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/form.html");

        //请求转发不能跳转到工程以外的资源
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("http://www.baidu.com");


        //走向Servlet2
        requestDispatcher.forward(req,resp);
    }
}
