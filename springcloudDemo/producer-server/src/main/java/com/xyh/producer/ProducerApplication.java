package com.xyh.producer;

import com.xyh.producer.pojo.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableEurekaClient   //表明自己是一个生产者服务
@MapperScan("com.xyh.producer.dao")
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/test")
    public Object home(@RequestParam String name)
    {
        Map<String,Object> map=new HashMap<>();
        User user=new User("xyh","1");
        String msg = "hi " + name + ",i am from port:" + port;
        map.put("user",user);
        map.put("msg",msg);
        return map;
    }

}
