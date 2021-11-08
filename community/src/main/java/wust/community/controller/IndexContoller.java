package wust.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//controller意为允许该类接收前端请求
@Controller
public class IndexContoller {
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    public String hello(@RequestParam(name = "name") String name, Model model){
        model.addAttribute("name",name);
        return "index";//如果返回hello，则自动去模板中找hello的模板
    }
}
