package net.xdclass.online_xdclass;

import io.jsonwebtoken.Claims;
import net.xdclass.online_xdclass.model.entity.User;
import net.xdclass.online_xdclass.utils.JWTUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class OnlineXdclassApplicationTests {

    @Test
    void testGeneJwt() {
        User user = new User();
        user.setId(66);
        user.setName("xdclass");
        user.setHeadImg("png");
        String token = JWTUtils.geneJsonWebToken(user);
        System.out.println(token);

        Claims claims = JWTUtils.checkJWT(token);
        System.out.println(claims.get("name"));
    }



}
