package com.htwy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Vv
 * @title: HystrixOrder80
 * @description: TODO
 * @date 2022/1/31:04 下午
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class HystrixOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixOrder80.class, args);
    }
}
