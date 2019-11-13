package com.example.ribbonturbine.service.impl;

import com.example.ribbonturbine.service.HelloRTService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: xiaqi
 * @Description:
 * @Date: Created in 15:05 05/11/2019
 * @modified By:
 */
@Service
public class HelloRTServiceImpl implements HelloRTService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "sayError")
    public String sayHi(String name) {
        return restTemplate.getForObject("http://eureka-client/hello/sayHi.ax?name=" + name, String.class);
    }

    @Override
    public String sayError(String name){
        return "hi," + name + ",This is a error";
    }
}
