package com.htwy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Vv
 * @title: PaymentHystrixMain8001
 * @description: TODO
 * @date 2022/1/311:59 上午
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //配合服务熔断
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class, args);
    }
}
