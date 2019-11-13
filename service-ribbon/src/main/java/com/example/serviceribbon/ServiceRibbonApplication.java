package com.example.serviceribbon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


//EnableEurekaClient 和 EnableDiscoveryClient区别在于 第一个只用于eureka-server发现本服务，第二个适用于任何服务发现本服务
@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class ServiceRibbonApplication {

    private static final Logger log = LoggerFactory.getLogger(ServiceRibbonApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonApplication.class, args);
    }

    @Bean
    @LoadBalanced //实现负载均衡
    //RestTemplate 实际上提供http连接的能力
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        log.info("service-ribbon 执行");
        return restTemplateBuilder.build();
    }


}
