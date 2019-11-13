package com.example.servicefeign.feignclient.hystrix;

import com.example.servicefeign.feignclient.EurekaClientApi;
import org.springframework.stereotype.Component;

@Component
public class EurekaClientApiHystrix implements EurekaClientApi {


    @Override
    public String sayHiFromClientOne(String name) {
        return "Hi," + name + ",This is a error";
    }
}
