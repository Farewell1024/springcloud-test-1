package com.zhangyu.helloservice.controller;

import com.zhangyu.helloservice.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Random;


/**
 * Created by zhangyu on 2018/9/5
 */
@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() throws InterruptedException {
        ServiceInstance instance = client.getLocalServiceInstance();

        //让处理线程等待几秒钟
        int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime:"+sleepTime);
//        Thread.sleep(sleepTime);

        logger.info("/hello, host:"+instance.getHost()+", service_id:"+instance.getServiceId());
        return "hello world!";
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "hello" + name;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader String name , @RequestHeader Integer age){
        return new User(name, age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user){
        return "Hello "+ user.getName()+", "+user.getAge();
    }


}
