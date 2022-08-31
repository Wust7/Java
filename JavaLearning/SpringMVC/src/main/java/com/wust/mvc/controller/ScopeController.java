package com.wust.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {

    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request){
        request.setAttribute("testRequestScope","hello.");
        return "scope";//请求转发   ---视图名称
    }

//   只要是放在request请求域中，都会生成ModelAndView,建议使用该方法来使用request域
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mav = new ModelAndView();
        //处理模型数据，即向请求域request共享数据
        mav.addObject("testRequestScope","hello,ModelAndView");

        //设置视图名称
        mav.setViewName("scope");
        return mav;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testRequestScope","hello,Model");
        /**
         * class ModelMap extends LinkedHashMap<String, Object>
         * class ExtendedModelMap extends ModelMap implements Model
         * class BindingAwareModelMap extends ExtendedModelMap
         */
        System.out.println(model.getClass().getName());//BindingAwareModelMap进行实例化
        return "scope";
    }

    @RequestMapping("/testMap")
    //通过Map直接映射到request域中
    public String testMap(Map<String,Object> map){
        map.put("testRequestScope","hello, Map");
        System.out.println(map.getClass().getName());
        return "scope";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope","hello,ModelMap");
        System.out.println(modelMap.getClass().getName());
        return "scope";
    }

    //向session域共享数据
    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","hello, Session");
        return "scope";
    }

    //向application域共享数据
    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope","hello, Application");
        return "scope";
    }
}
