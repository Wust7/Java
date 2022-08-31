package com.wust.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class TestServlet implements Servlet {

    public TestServlet() {
        System.out.println("HelloServlet构造方法被调用------1");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init方法被调用---------2");

        //1.获取Servlet程序的别名servlet-name的值
        System.out.println("TestServlet程序别名："+servletConfig.getServletName());

        //2.获取初始化参数
        System.out.println("获取web.xml的参数："+servletConfig.getInitParameter("username"));
        System.out.println("获取web.xml的参数："+servletConfig.getInitParameter("url"));

        //3.获取servlet的context对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法专门用来处理请求和响应
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet 被访问了------------3");

        String method = ((HttpServletRequest) servletRequest).getMethod();
        /**
         * 由于一个方法一般只做一件事，因而针对get和post设计不同方法执行
         */
        if(method.equals("GET")){
            doGet();
        }else{
            doPost();
        }
    }


    public void doGet(){
        System.out.println("Get方法被调用");
    }

    public void doPost(){
        System.out.println("Get方法被调用");
    }
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁方法被调用-----------4");
    }
}
