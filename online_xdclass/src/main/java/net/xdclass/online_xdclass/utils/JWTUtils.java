package net.xdclass.online_xdclass.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.xdclass.online_xdclass.model.entity.User;

import java.util.Date;

/**
 * Jwt（Json Web token）工具类
 * Jwt=头部+负载+签名
 * 注意点:
 * 1、生成的token, 是可以通过base64进行解密出明文信息
 * 2、base64进行解密出明文信息，修改再进行编码，则会解密失败
 * 3、无法作废已颁布的token，除非改秘钥
 */
public class JWTUtils {


    /**
     * 过期时间，一周
     */
    private static final long EXPIRE = 60000 * 60 * 24 * 7;
    //private  static final long EXPIRE = 1;


    /**
     * 加密秘钥：以免未知人员直接通过token进行解密
     */
    private  static final String SECRET = "xdclass.net168";


    /**
     * 令牌前缀
     */
    private  static final String TOKEN_PREFIX = "xdclass";


    /**
     * subject
     */
    private  static final String SUBJECT = "xdclass";


    /**
     * 根据用户信息，生成令牌
     * @param user
     * @return
     */
    public static String geneJsonWebToken(User user){

        String token = Jwts.builder().setSubject(SUBJECT)//编入主题
                .claim("head_img",user.getHeadImg())//用户属性
                .claim("id",user.getId())
                .claim("name",user.getName())
                .setIssuedAt(new Date())//令牌颁布时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))//设置过期时间
                //signWith指定签名方式
                //SignatureAlgorithm加密方式
                //SECRET密钥
                .signWith(SignatureAlgorithm.HS256,SECRET).compact();

        token = TOKEN_PREFIX + token;//添加前缀
        return token;
    }


    /**
     * 校验token的方法
     * @param token
     * @return
     */
    public static Claims checkJWT(String token){

        try{
            //parser:解析密钥
            //setSigningKey：设置签名密钥
            //parseClaimsJws:解密
            //token.replace(TOKEN_PREFIX,""):删除token前缀
            //声明为final类型，以免被篡改
            final  Claims claims = Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX,"")).getBody();

            return claims;

        }catch (Exception e){
            return null;
        }

    }



}
