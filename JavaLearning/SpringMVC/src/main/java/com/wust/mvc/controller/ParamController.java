package com.wust.mvc.controller;

import com.wust.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class ParamController {

    @RequestMapping("/testServletAPI")
    //形参位置的request表示当前请求
    public String testServletAPI(HttpServletRequest request){
        /**
         * 对于第一次session而言，服务器端会创建一个session，同时cookie作为其key传送给客户端，
         * 该cookie第一次会存在客户端的response Header中，之后将存放在request Header中。
         * cookie作为以后每次访问服务端的key，以后每次会话客服端都通过将cookie值去服务端session池中寻找session，匹配成功则进行会话。
         * 若客户端cookie被删除，则会新建session，得到新的cookie
         */

        HttpSession session = request.getSession();
        //不能与rest风格混用
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+","+password);
        return "success";
    }

    @RequestMapping("/testParam")
    //只需要形参名称与请求参数名称一致就可以自动赋值,否则不行，但可以通过RequestParam实现映射对应
    public String testParam(
            //名称不同时，通过RequestParam实现映射对应
            @RequestParam("user_name") String username,
            //required = false表示有则赋值，没有则为null，其required默认为true表示必须赋值否则报错
            //defaultValue表示默认值，若设置默认值了，即使required为false也同样可以
            @RequestParam(value = "user_name", required = false,defaultValue = "JYQ") String password,
            String[] hobby,
            //将请求头中的Host值与host形参建立映射,与RequestParam不同，请求头没有默认对应
            @RequestHeader(value = "Host",required = true,defaultValue = "localhost:8081")String host,
            @CookieValue("JSESSIONID")String JSESSIONID

            ){
        //若请求参数中出现多个同名参数，则可以在控制器方法的形参位置设置字符串或字符串数组接收此数据
        //若使用字符串类型的形参，则每一个值之间以逗号隔开
        System.out.println(username+","+password+","+ Arrays.toString(hobby));
        System.out.println(host);
        System.out.println(JSESSIONID);
        return "success";
    }

    @RequestMapping("/testBean")
    /**
     * 通过实体类直接获取参数，需要保证请求参数名称与实体类中的名称一一对应
     */
    public String testBean(User user){
        System.out.println(user);
        return "success";
    }
}
