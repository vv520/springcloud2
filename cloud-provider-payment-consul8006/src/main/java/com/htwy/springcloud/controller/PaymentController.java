package com.htwy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Vv
 * @title: PaymentController
 * @description: TODO
 * @date 2021/12/267:45 下午
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    public String paymentzk(){
        return "------springcloud with consul:" + serverPort + "\t" + UUID.randomUUID().toString();

    }
}
