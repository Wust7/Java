package com.wust.demoproject.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "userServlet",urlPatterns = "/api/v1/test/customs")
/**
 * 等价于去web.xml中配置
 *     <servlet>
 *         <servlet-name>userServlet</servlet-name>
 *         <servlet-class>com.wust.demoproject.UserServlet</servlet-class>
 *     </servlet>
 *     <servlet-mapping>
 *         <servlet-name>userServlet</servlet-name>
 *         <url-pattern>/api/v1/test/customs</url-pattern>
 *     </servlet-mapping>
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("servlet...");
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
