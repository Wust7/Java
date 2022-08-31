package com.wust.web;

import com.wust.pojo.User;
import com.wust.service.UserService;
import com.wust.service.impl.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//第八步：web层servlet类
public class RegisterServlet extends HttpServlet {

    //web层不能直接操作Dao，因此通过创建UserService来间接访问
    private UserService userService = new UserServiceImpl();

    @Override
    public void init(ServletConfig config) throws ServletException {
        //重写的话一定要调用父类init，因为父类中该方法保存了config
        super.init(config);
        System.out.println("重写HttpServlet方法的init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入doPost");
        //1.获取请求参数
        String username = req.getParameter("username");//从regist.html中registerServlet获取
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");//验证码
        System.out.println("***"+username);
        //2.验证码检测 --- 目前先写死 abcde
        if ("abcde".equalsIgnoreCase(code)) {//equalsIgnoreCase:忽略大小写
            //3.检查用户名是否可用
            if (userService.existUsername(username)) {
                //不可用
                System.out.println("用户名[" + username + "]已存在");
                req.setAttribute("msg","用户名已存在！！");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                //用户存在，跳回注册页面
                req.getRequestDispatcher("pages/user/regist.jsp").forward(req, resp);
            } else {
                //可用,调用registerUser保存到数据库
                userService.registerUser(new User(null, username, password, email));
                //保存成功，跳回regist_success.html页面
                req.getRequestDispatcher("pages/user/regist_success.jsp").forward(req, resp);
            }

        } else {
            //不正确，跳回注册页面

            req.setAttribute("msg","验证码错误！！");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            System.out.println("验证码错误");
            /**
             * forward :请求转发
             * 由下一个Servlet完成响应体，当前Servlet可以设置响应头（留头不留体）。
             * 举个例子，AServlet请求转发到BServlet，那么AServlet不能够使用response.getWriter（） 和response.getOutputStream（）
             * 向客户端输出响应体，但可以使用response.setContentType("text/html;charset=utf-8") 设置响应头。而在BServlet中可以输出响应体。
             *
             * include：请求包含
             * 由两个Servlet共同完成响应体（留头又留体）。AServlet请求包含到BServlet，那么AServlet既可以设置响应头，也可以完成响应体。
             */
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}
