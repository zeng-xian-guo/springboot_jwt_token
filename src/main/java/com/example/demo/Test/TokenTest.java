package com.example.demo.Test;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.Common.JwtTokenUtil;

import java.util.Map;

public class TokenTest {
    public static void main(String[] args) throws Exception {
        //生成token
        /*String token = JwtTokenUtil.createToken("1","123456");
        System.out.println("token:" + token);*/
        //校验token
        /*Boolean verify = JwtTokenUtil.verifyToken(token,"123456");
        System.out.println("verify:" + verify);*/
        //获取Token信息
        /*DecodedJWT tokenInfo = JwtTokenUtil.getTokenInfo(token);
        String alg = tokenInfo.getHeaderClaim("alg").asString();
        System.out.println("alg:"+alg);
        Map<String, Claim> claims = tokenInfo.getClaims();
        System.out.println("org:" + claims.get("org").asString());
        System.out.println("exp:" + claims.get("exp").asDate());*/
    }

}
