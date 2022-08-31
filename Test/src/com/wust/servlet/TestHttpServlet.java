package com.wust.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

//处理Servlet时，实际开发中一般使用继承HttpServlet
public class TestHttpServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        //重写的话一定要调用父类init，因为父类中该方法保存了config
        super.init(config);
        System.out.println("重写HttpServlet方法的init");
    }

    /**
     * get请求时调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //只能获取自己配置列表中的参数
        ServletConfig servletConfig = getServletConfig();
        System.out.println("get请求被调用");

        //获取请求的资源路径
        System.out.println("URI:"+req.getRequestURI());

        //获取请求的统一资源定位符（绝对路径）
        System.out.println("URL:"+req.getRequestURL());

        /**
         * 获取客户端ip地址
         */
        System.out.println("客户端IP地址："+req.getRemoteHost());//127.0.0.1

        //获取请求头User-Agent
        System.out.println("请求头User-Agent："+req.getHeader("User-Agent"));

        //获取请求方式
        System.out.println("请求方式："+req.getMethod());

        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobby = req.getParameterValues("hobby");
        System.out.println(username+","+password+","+ Arrays.asList(hobby));
    }

    /**
     * Post请求时调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post请求被调用");

        //设置请求体的字符集为UTF-8，从而解决post请求的中文乱码问题
        //同时也要在获取请求参数之前调用才有效
        req.setCharacterEncoding("UTF-8");

        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobby = req.getParameterValues("hobby");
        System.out.println(username+","+password+","+ Arrays.asList(hobby));

    }

}
