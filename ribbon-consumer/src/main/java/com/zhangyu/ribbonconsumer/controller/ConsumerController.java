package com.zhangyu.ribbonconsumer.controller;

import com.zhangyu.ribbonconsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhangyu on 2018/9/5
 */
@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService.helloService();
    }

}
