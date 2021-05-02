package com.valid.youtu.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.valid.youtu.entity.User;

import java.util.Date;

public class TokenUtil {
    private static final String ISSUER = "youtu";
    private static final long EXPIRE_TIME = 24*60*60*1000;
//    private static final String TOKEN_SECRET = UUIDUtil.getUUID();  //密钥盐
    private static final String TOKEN_SECRET = "UUIDUtil.getUUID()";  //密钥盐

    // 获取token
    public static String getToken(User user){
        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer(ISSUER)
                    .withClaim("username", user.getUserName()) // 保存用户名
                    .withClaim("auth", user.getAuth().getCode()) // 保存用户的权限
                    .withExpiresAt(expiresAt) // 过期时间
                    .withIssuedAt(new Date()) // 签发日期
                    .sign(Algorithm.HMAC256(TOKEN_SECRET)); // 签发算法
        } catch (Exception e){
            e.printStackTrace();
        }
        return token;
    }

    // 验证token
    public static DecodedJWT verify(String token){
        return JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).
                withIssuer(ISSUER).build().verify(token);// 验证token
    }

    // 解析token获取claim
    public static String getClaimByName(String token, String key) {
        try {
            DecodedJWT decode = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).
                    withIssuer(ISSUER).build().verify(token);// 验证token
            return decode.getClaim(key).asString();
        } catch (Exception e){
            return "";
        }
    }
}