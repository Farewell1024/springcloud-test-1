package com.zhangyu.feignconsumer.controller;

import com.zhangyu.feignconsumer.model.User;
import com.zhangyu.feignconsumer.service.HelloService;
import com.zhangyu.feignconsumer.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangyu on 2018/9/11
 */
@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2(){
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("/Zhang Yu")).append("\n");
        sb.append(helloService.hello("/Zhang Yu", 18)).append("\n");
        sb.append(helloService.hello(new User("Yu", 18))).append("\n");
        return sb.toString();
    }

    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer3(){
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("/Zhang Yu")).append("\n");
        sb.append(refactorHelloService.hello("/Zhang Yu", 18)).append("\n");
        sb.append(refactorHelloService.hello(new com.zhangyu.helloserviceapi.model.User("Yu", 18))).append("\n");
        return sb.toString();
    }

}
