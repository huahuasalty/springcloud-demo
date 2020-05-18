package com.xyh.consumer.controller;

import com.xyh.consumer.service.ConsumeService;
import com.xyh.producer2.pojo.OutData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumeController {
    @Autowired
    private ConsumeService consumeService;

    @RequestMapping("/test")
    public OutData hello(String name){
        return consumeService.hello(name);
    }
}
