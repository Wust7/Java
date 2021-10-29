package wust.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wust.community.dto.AccessTokenDO;
import wust.community.dto.GithubUser;
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

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;




    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDO accessTokenDO = new AccessTokenDO();
        accessTokenDO.setCode(code);
        accessTokenDO.setState(state);
        accessTokenDO.setClient_id(clientId);
        accessTokenDO.setClient_secret(clientSecret);
        accessTokenDO.setRedirect_uri(redirectUri);
        String accessToken = githubProvider.getAccessToken(accessTokenDO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
