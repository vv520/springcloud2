package com.htwy.springcloud.controller;

import com.htwy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Vv
 * @title: PaymentController
 * @description: TODO
 * @date 2022/1/312:06 下午
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") int id){
        String result = paymentService.paymentInfo_OK(id);
        log.info("------result:{}", result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") int id){
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("------result:{}", result);
        return result;
    }
}
