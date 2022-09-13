package com.wust.demoproject.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wust.demoproject.domain.User;
import com.wust.demoproject.service.impl.UserServiceImpl;
import com.wust.demoproject.utils.JsonData;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//@WebFilter(urlPatterns = "/api/v1/pri/*",filterName = "loginFilter")//配置过滤路径
public class LoginFilter implements Filter {

    //用于json序列化
    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init....");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter....");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String token = req.getHeader("token");//首先从header中获取
        if(StringUtils.isEmpty(token)){
            token = req.getParameter("token");//前面未获取到则去Parameter中获取
        }
        if(!StringUtils.isEmpty(token)){
            //判断token是否合法 TODO
            User user = UserServiceImpl.sessionMap.get(token);
            if(user!=null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                JsonData json = JsonData.buildError("登录失败，token无效", -2);
                String jsonStr = objectMapper.writeValueAsString(json);
                renderJson(resp,jsonStr);
            }
        }else{
            JsonData json = JsonData.buildError("未登录", -3);
            String jsonStr = objectMapper.writeValueAsString(json);
            renderJson(resp,jsonStr);
        }
    }

    private void renderJson(HttpServletResponse response,String json){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try(PrintWriter writer = response.getWriter()){
            writer.print(json);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    @Override
    public void destroy() {
        System.out.println("destroy....");
    }
}
