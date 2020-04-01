package com.example.demo.Common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtil {

    //公用密钥-保存在服务端,客户端是不会知道密钥的,以防被攻击
    public static String SECRET = "ThisIsASecret";

    //生成Troke
    public static String createToken(String username) {
        //签发时间
        //Date iatDate = new Date();
        //过地时间  1分钟后过期
        //Calendar nowTime = Calendar.getInstance();
        //nowTime.add(Calendar.MINUTE, 1);
        //Date expiresDate = nowTime.getTime();
        Map<String, Object> map = new HashMap();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                    .withHeader(map)
                    //.withClaim( "name","Free码生") //设置 载荷 Payload
                    //.withClaim("age","12")
                    //.withClaim( "org","测试")
                    //.withExpiresAt(expiresDate)//设置过期时间,过期时间要大于签发时间
                    //.withIssuedAt(iatDate)//设置签发时间
                    .withAudience(username) //设置 载荷 签名的观众
                    .sign(Algorithm.HMAC256(SECRET));//加密
        System.out.println("后台生成token:" + token);
        return token;
    }

    //校验TOKEN
    public static boolean verifyToken(String token) throws UnsupportedEncodingException{
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        try {
            verifier.verify(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    //获取Token信息
    public static DecodedJWT getTokenInfo(String token) throws UnsupportedEncodingException{
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        try{
            return verifier.verify(token);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}

/*//resources--JWT生成TOKEN及验证.pdf
//公用密钥-保存在服务端,客户端是不会知道密钥的,以防被攻击
public static String SECRET = "ThisIsASecret";
//生成Troke
public static String createToken(String id,String password) {
        //签发时间
        Date iatDate = new Date();
        //过地时间  1分钟后过期
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 1);
        Date expiresDate = nowTime.getTime();
        Map<String, Object> map = new HashMap();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                    .withHeader(map)
                    .withClaim( "name","Free码生") //设置 载荷 Payload
                    .withClaim("age","12")
                    .withClaim( "org","测试")
                    .withExpiresAt(expiresDate)//设置过期时间,过期时间要大于签发时间
                    .withIssuedAt(iatDate)//设置签发时间
                    .sign(Algorithm.HMAC256(SECRET));//加密
        return token;
}
//校验TOKEN
public static boolean verifyToken(String token,String password) throws UnsupportedEncodingException{
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        try {
            verifier.verify(token);
            return true;
        } catch (Exception e){
            return false;
        }
}
//获取Token信息
public static DecodedJWT getTokenInfo(String token) throws UnsupportedEncodingException{
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        try{
            return verifier.verify(token);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
}
//测试
public static void main(String[] args) throws Exception {
        //生成token
        String token = JwtTokenUtil.createToken();
        System.out.println("token:" + token);
        //校验token
        Boolean verify = JwtTokenUtil.verifyToken(token);
        System.out.println("token 校验结果:" + verify);
        //获取Token信息
        DecodedJWT tokenInfo = JwtTokenUtil.getTokenInfo(token);
        String alg = tokenInfo.getHeaderClaim("alg").asString();
        System.out.println("alg:"+alg);
        Map<String, Claim> claims = tokenInfo.getClaims();
        System.out.println("org:" + claims.get("org").asString());
        System.out.println("exp:" + claims.get("exp").asDate());
}
 */


