package Base.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建Cookie对象
        Cookie cookie = new Cookie("key1", "value1");

        //通知客户端保存cookie
        resp.addCookie(cookie);

        resp.getWriter().write("Cookie创建成功");
    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            //getName返回Cookie的key
            resp.getWriter().write("Cookie["+cookie.getName()+"="+cookie.getValue()+"]<br/>");
        }
    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //方案一
        //客户端收到set-cookie响应头后，若发现key1存在则修改，不存在则创建
//        Cookie cookie = new Cookie("key1","newValue1");
//        resp.addCookie(cookie);
//        resp.getWriter().write("key1修改完成");

        //方案二
        Cookie cookieUp = null;
        for (Cookie cookie : req.getCookies()) {
            if("key1".equals(cookie.getName())){
                cookieUp = cookie;
            }
        }
        cookieUp.setValue("newValue2");
        resp.addCookie(cookieUp);

    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defaultLife", "defaultLife");

        /**
         * 正数表示在指定的秒数后过期
         * 负数表示浏览器一关，Cookie就会被删除（默认值-1）
         * 0表示马上删除Cookie
         */
        cookie.setMaxAge(-1);//设置存活时间
        resp.addCookie(cookie);

    }

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "path1");
        //req.getContextPath() 得到工程路径
        cookie.setPath(req.getContextPath()+"/abc");//设置cookie路径
        resp.addCookie(cookie);
        resp.getWriter().write("设置工程路径成功");

    }
}
