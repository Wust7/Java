package Base.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if("wst".equals(username)&&"111".equals(password)){
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60);
            resp.addCookie(cookie);
            System.out.println("success");

            req.getSession().setAttribute("user",username);

        }else{
            System.out.println("error");
        }
    }
}
