package com.wust.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestContextServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取web.xml全局参数
        ServletContext context = getServletContext();
        System.out.println(context.getInitParameter("name1"));
        System.out.println(context.getInitParameter("name2"));

        //2.获取当前的工程路径
        System.out.println(context.getContextPath());

        //3.获取工程部署后在服务器硬盘上的绝对路径
        System.out.println(context.getRealPath("/"));

        //4.整个web工程都可访问
        context.setAttribute("key1","value1");
        System.out.println("TestContextServlet获取域数据："+context.getAttribute("key1"));

        //5.获取请求资源路径
    }
}
