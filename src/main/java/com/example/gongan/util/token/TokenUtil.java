package com.example.gongan.util.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.gongan.entity.rule;

import java.util.Date;
import java.util.Map;

public class TokenUtil {
    private static final long EXPIRE_TIME= 60*60*1000; //过期时间：1 hour
    private static final String TOKEN_SECRET="HaiQing";  //密钥盐

    /**
     * 签名生成
     * @param
     * @return
     */
    public static String sign(rule rule){
        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("username", rule.getName())
                    .withExpiresAt(expiresAt)
                    // 使用了HMAC256加密算法。
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(rule.getName()+"用户生成的Token为："+token);
        return token;
    }

    /**
     * 签名验证
     * @param token
     * @return
     */
    public static Integer verify(String token){
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            Date time = new Date();
            System.out.println(jwt.getExpiresAt().getTime() - time.getTime());
            if(jwt.getExpiresAt().getTime() - time.getTime() < 30*60*1000){ // 距离过期时间30分钟调用接口， 则调用自动刷新token接口
                return 2;
            }else {
                return 1;
            }
//            return true;
        } catch (Exception e){
//            return false;
            return -1;
        }
    }
    //解析token并在token中取出username
    public static String analysisToken(String token) {
        try {
            //如果没有上面的验证，也可以直接使用JWT.decode(token)返回jwt然后再getClaims()
            DecodedJWT jwt = JWT.decode(token);
            Map<String, Claim> claims = jwt.getClaims();
            Claim claim = claims.get("username");
            return claim.asString();
        } catch (Exception exception){
//			exception.printStackTrace();
            return null;
        }
    }
}
