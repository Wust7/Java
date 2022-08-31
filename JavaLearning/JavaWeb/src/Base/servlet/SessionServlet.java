package Base.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet{

    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建和获取session会话对象 --------------若cookie对象被删除，但是session会话未超时，系统仍然会创建一个新的session会话与新的cookie值，
        // ps:关闭浏览器，cookie就没有了
        HttpSession session = req.getSession();
        //判断当前session会话是否是新创建出来的
        boolean isNew = session.isNew();
        //获取session会话的唯一标识id
        String id = session.getId();

        resp.getWriter().write("Session的id是："+id+"<br/>");
        resp.getWriter().write("是否为新创建的："+isNew+"<br/>");

    }

    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1","value1");
        resp.getWriter().write("key1创建成功");

    }

    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().write("key1:"+attribute);

    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session的默认超时时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();//默认1800s
        resp.getWriter().write(maxInactiveInterval);
    }

    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(3);//负数表示永不超时
        resp.getWriter().write("超时时长设置为3s");
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.getWriter().write("session已经设置为超时或无效");
    }
}
