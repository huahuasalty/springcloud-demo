package com.xyh.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xyh.producer2.pojo.OutData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumeService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloError")   //短路器，如果该方法出错则执行helloError方法，所以该方法与请求的方法返回值要一致
    public OutData hello(String name){
        System.out.println(name);
        OutData forObject= restTemplate.getForObject("http://producer-server2/dept/queryAll" , OutData.class);
//        ResponseEntity<Object> forentity=restTemplate.getForEntity("http://producer-server/dept/queryAll?name=" + name,Object.class);
        return forObject;
    }

    public OutData helloError(String name){
        OutData out =new OutData();
        out.setMsg("hey "+name+",something go wrong,try it again ");
        out.setCode(-1);
        return out;
    }

}
