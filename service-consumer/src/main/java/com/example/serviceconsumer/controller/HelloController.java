package com.example.serviceconsumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xiaqi
 * @Description:
 * @Date: Created in 10:08 05/11/2019
 * @modified By:
 */

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Value("${server.port}")
    String serverPort;

    @GetMapping(value = "/sayHi.ax")
    public String sayHi(@RequestParam(value = "name", defaultValue = "xx") String name){
        log.info("===============eureka-client 执行===============");
        return "hi,"  + name + " ,i am from port:" + serverPort;
    }
}
