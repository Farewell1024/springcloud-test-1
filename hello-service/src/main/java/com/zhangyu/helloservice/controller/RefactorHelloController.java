package com.zhangyu.helloservice.controller;

import com.zhangyu.helloserviceapi.model.User;
import com.zhangyu.helloserviceapi.service.HelloService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangyu on 2018/9/11
 */
@RestController
public class RefactorHelloController implements HelloService {
    @Override
    public String hello(@RequestParam("name") String name) {
        return "hello" + name;
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User(name, age);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "Hello "+ user.getName() + ", " + user.getAge();
    }
}
