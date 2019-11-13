package com.example.configclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: xiaqi
 * @Description:
 * @Date: Created in 11:34 06/11/2019
 * @modified By:
 */

@RestController
@RequestMapping(value = "/hello")
@RefreshScope
public class HelloController {

    @Value("${foo}")
    String foo;

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @PostMapping(value = "/sayHi.ax")
    public String sayHi(){

        log.info("===============config-client 执行===============");
        return foo;
    }

}
