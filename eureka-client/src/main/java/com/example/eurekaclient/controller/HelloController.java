package com.example.eurekaclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
