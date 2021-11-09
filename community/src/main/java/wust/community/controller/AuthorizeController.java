package wust.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wust.community.dto.AccessTokenDO;
import wust.community.dto.GithubUser;
import wust.community.provider.GithubProvider;

import javax.servlet.http.HttpServletRequest;

/**
 * 授权页面
 */
@Controller
public class AuthorizeController {
    /**
     * 通过Component注解将provider放到了容器里面，通过Autowired使用
     * @param code
     * @param state
     * @return
     */

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;




    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request){
        AccessTokenDO accessTokenDO = new AccessTokenDO();
        accessTokenDO.setCode(code);
        accessTokenDO.setState(state);
        accessTokenDO.setClient_id(clientId);
        accessTokenDO.setClient_secret(clientSecret);
        accessTokenDO.setRedirect_uri(redirectUri);
        System.out.println("********************");
        String accessToken = githubProvider.getAccessToken(accessTokenDO);
        GithubUser user = githubProvider.getUser(accessToken);
        if(user!=null){
            //登陆成功，写Cookies和Session
            System.out.println(user.getName());
            //相当于银行账户创建成功但未给银行卡
            request.getSession().setAttribute("user",user);
            return "redirect:index";//跳转回登录页面  ， 如果不写redirect的话，网页地址不会变还是原来的，写了的话会重新跳转回登录界面
        }else{
            //登录失败，重新登录
            return "redirect:index";
        }
    }
}
