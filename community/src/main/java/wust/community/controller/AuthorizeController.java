package wust.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wust.community.dto.AccessTokenDO;
import wust.community.provider.GithubProvider;

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

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
//        AccessTokenDO accessTokenDO = new AccessTokenDO();
//        accessTokenDO.setCode(code);
//        accessTokenDO.setState(state);
//        accessTokenDO.setClient_id("Iv1.e67e5d34c9d44454");
//        accessTokenDO.setClient_secre("f145e8349e2a32215e81588b3c1bf00f6cbf2a44");
//        accessTokenDO.setRedirect_uri("http://localhost:8081/callback");
//        githubProvider.getAccessToken(accessTokenDO);
        return "index";
    }
}
