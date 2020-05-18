package com.xyh.producer.util;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
public class LoginToken {
    /*
     *过期时间
     *3分种
     */
    private static final long OUT_TIME=3*60*1000;
    /*
     * 生成加密签名方法
     * @Param username
     * @Param userId
     * @returnString
     */
    public static String creatSign(String username,String userId){
        try {
//       过期时间
            Date date = new Date(System.currentTimeMillis() +OUT_TIME);
//       密钥及加密算法
// 		 这里的密钥MessageEnum.messageEnum(11).toString()我使用的是枚举，您可以自己定义一个密钥比如 String sign="我的密钥是........";
            Algorithm algorithm=Algorithm.HMAC256("this is my private sign".toString());
//       设置头部信息
            Map<String,Object> header=new HashMap<>(2);
            header.put("typ", "JWT");
            header.put("alg", "HS256");
//       附带username,userId信息，生成签名
            return JWT.create()
                    .withHeader(header)
                    .withClaim("loginName",username )
                    .withClaim("userId", userId)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Description: //校验token是否合法
     * @Param:token
     * @return:boolean
     * @Author: Mr.Lzl
     * @Date: 2019/1/31
     * @Time: 19:41
     **/

    public static boolean decodesign(String token){//校验token是否合法
        try {
            // 		 这里的密钥MessageEnum.messageEnum(11).toString()我使用的是枚举，您可以自己定义一个密钥比如 String sign="我的密钥是........";
            Algorithm algorithm=Algorithm.HMAC256("this is my private sign".toString());
            JWTVerifier verifier=JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return  true;
        } catch (UnsupportedEncodingException exception){
            System.out.println("UTF-8 encoding not supported");
            return false;
            //UTF-8 encoding not supported
        } catch (JWTVerificationException exception){//token时间过期或者是token是非法的
            //Invalid signature/claims
            System.out.println("Invalid signature/claims");
            return false;
        }
    }

    /**
     * 获取token的值
     * @param token
     *
     * @return String
     */

    public static String decodeToken(String token) {

        try {
            DecodedJWT jwt = JWT.decode(token);
            String payload =jwt.getClaim("loginName").asString() ;//获取token的loginName的值
            return payload;
        } catch (JWTDecodeException exception) {
            //Invalid token
            System.out.println("Invalid signature/claims");
            return null;
        }
    }
}
