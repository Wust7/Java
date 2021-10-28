package wust.community.provider;

import okhttp3.*;
import org.springframework.stereotype.Component;
import wust.community.dto.AccessTokenDO;

import java.io.IOException;

/**
 * 获取github用户数据
 * Component注解会自动将对象实例化到一个池子里面，不需要再实例化
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDO accessTokenDO){
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            System.out.println(string);
            return string;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
