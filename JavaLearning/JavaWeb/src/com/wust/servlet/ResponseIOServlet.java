package com.wust.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(resp.getCharacterEncoding());//默认ISO-8859-1

        //设置服务器字符集为UTF-8
//        resp.setCharacterEncoding("UTF-8");

        //通过响应头，设置浏览器也使用UTF-8字符集
//        resp.setHeader("Content-Type","text/html;charset=UTF-8");

        //同时设置服务器和客户端都使用UTF-8字符集，以及设置响应头
        // 此方法一定要在获取流对象之前调用才有效
        resp.setContentType("text/html;charset=UTF-8");

        //只能使用一个，否则会报错
//        resp.getWriter();//字符流
//        resp.getOutputStream();//字节流

        PrintWriter writer = resp.getWriter();
        writer.write("JYQ真可爱!");


    }
}
