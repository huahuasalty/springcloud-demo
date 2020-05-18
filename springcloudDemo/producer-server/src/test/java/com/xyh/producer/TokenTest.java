package com.xyh.producer;

import com.xyh.producer.util.LoginToken;
import org.junit.Test;

public class TokenTest {
    @Test
    public void creatToken() {//生成的token
        try {
            System.out.println(LoginToken.creatSign("we", "me"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void decodesign() {//校验token是否合法
        try {            System.out.println(LoginToken.decodesign(LoginToken.creatSign("we", "me")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void decodeToken() {//获取token的值
        System.out.println( LoginToken.decodeToken("上面的方法生成的token值"));
    }

}
