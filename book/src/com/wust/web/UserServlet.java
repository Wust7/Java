package com.wust.web;

import com.wust.pojo.User;
import com.wust.service.UserService;
import com.wust.service.impl.UserServiceImpl;
import com.wust.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//整合LoginServlet和RegisterServlet
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
     * 处理登录业务
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //调用userService处理登陆业务
        User loginUser = userService.login(new User(null, username, password, null));

        if (loginUser == null) {
            //把错误信息和回显得表单项信息，保存到Request域中
            req.setAttribute("msg", "用户或密码错误！");
            req.setAttribute("username", username);

            //登陆失败,跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            //登录成功
            //保存用户到session中
            req.getSession().setAttribute("user",loginUser);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    /**
     * 处理注册业务
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
        String username = req.getParameter("username");//从regist.html中registerServlet获取
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");//验证码

        //通过User的set方法进行user值设置
        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());

        //2.验证码检测 --- 目前先写死 abcde
        if ("abcde".equalsIgnoreCase(code)) {//equalsIgnoreCase:忽略大小写
            //3.检查用户名是否可用
            if (userService.existUsername(username)) {
                //不可用
                System.out.println("用户名[" + username + "]已存在");
                req.setAttribute("msg", "用户名已存在！！");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
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

            req.setAttribute("msg", "验证码错误！！");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
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
