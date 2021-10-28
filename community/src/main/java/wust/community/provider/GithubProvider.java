package wust.community.provider;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.stereotype.Component;
import wust.community.dto.AccessTokenDO;
import wust.community.dto.GithubUser;

import java.io.IOException;

/**
 * 获取github用户数据
 * Component注解会自动将对象实例化到一个池子里面，不需要再实例化
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDO accessTokenDO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
//        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDO));
        RequestBody body=RequestBody.Companion.create(JSON.toJSONString(accessTokenDO),mediaType);
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            System.out.println(string);
            return string;
        } catch (IOException e) {
        }
        return null;
    }
    public GithubUser getUser(String access_token){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization","token "+access_token)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
