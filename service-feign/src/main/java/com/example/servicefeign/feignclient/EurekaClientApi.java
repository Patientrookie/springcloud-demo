package com.example.servicefeign.feignclient;

import com.example.servicefeign.feignclient.hystrix.EurekaClientApiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client",fallback = EurekaClientApiHystrix.class)
public interface EurekaClientApi {

    @GetMapping(value = "/hello/sayHi.ax")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
