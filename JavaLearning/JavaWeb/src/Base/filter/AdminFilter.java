package Base.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    public AdminFilter() {
        System.out.println("1.Filter构造器方法");//web工程启动时开始执行
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2.Filter的init方法");//web工程启动时开始执行

        //获取filter的名称filter-name
        System.out.println("filter-name："+filterConfig.getFilterName());

        //获取web.xml中配置的init-param初始化参数
        System.out.println("init-param:"+filterConfig.getInitParameter("name")+","+filterConfig.getInitParameter("age"));

        //获取ServletContext对象
        System.out.println(filterConfig.getServletContext());
    }

    /**
     * 专门用于拦截请求，可以做权限检查
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3.Filter的doFilter方法");//每次拦截的到请求就会执行
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        if(user==null){
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
        }else{
            /**
             * FilterChain.doFilter:
             * 1.执行下一个Filter过滤器
             * 2.执行目标资源
             */
            //让程序继续往下访问用户目标资源,没有该方法，程序无法继续执行
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("3.Filter的destroy方法");//停止web工程就会执行，也会销毁Filter过滤器
    }
}
