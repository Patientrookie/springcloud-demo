package com.example.ribbonturbine.controller;

import com.example.ribbonturbine.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xiaqi
 * @Description:
 * @Date: Created in 15:04 05/11/2019
 * @modified By:
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    HelloService helloService;

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping(value = "/sayHi.ax")
    public String sayHi(@RequestParam("name") String name){
        log.info("===============service-ribbon 执行===============");
        return helloService.sayHi(name);
    }

}
