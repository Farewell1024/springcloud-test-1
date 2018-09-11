package com.zhangyu.feignconsumer.service;

import com.zhangyu.helloserviceapi.service.HelloService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by zhangyu on 2018/9/11
 */
@FeignClient(value = "hello-service")
public interface RefactorHelloService extends HelloService {
}
