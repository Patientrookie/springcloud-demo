package com.example.ribbonturbine;

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

@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class RibbonTurbineApplication {

    private static final Logger log = LoggerFactory.getLogger(RibbonTurbineApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RibbonTurbineApplication.class, args);
    }

    @Bean
    @LoadBalanced //实现负载均衡
    //RestTemplate 实际上提供http连接的能力
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        log.info("service-ribbon 执行");
        return restTemplateBuilder.build();
    }

}
