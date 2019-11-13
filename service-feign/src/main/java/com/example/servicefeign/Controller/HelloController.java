package com.example.servicefeign.Controller;

import com.example.servicefeign.feignclient.EurekaClientApi;
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
 * @Date: Created in 17:14 05/11/2019
 * @modified By:
 */

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    EurekaClientApi eurekaClientApi;

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/sayHi.ax")
    public String sayHi(@RequestParam(value = "name") String name) {
        log.info("===============service-feign 执行===============");
        return eurekaClientApi.sayHiFromClientOne(name);
    }
}
