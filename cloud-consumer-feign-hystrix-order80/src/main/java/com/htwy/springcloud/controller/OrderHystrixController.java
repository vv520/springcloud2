package com.htwy.springcloud.controller;

import com.htwy.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Vv
 * @title: PaymentHystrixController
 * @description: TODO
 * @date 2022/1/31:08 下午
 */
@RestController
//可在service层统一配置一个fallback类，就不需要一下的@DefaultProperties和@HystrixCommand
@DefaultProperties(defaultFallback = "global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") int id) {
        String result = paymentService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })*/
    @HystrixCommand //属性配置由@DefaultProperties配置
    public String paymentInfo_TimeOut(@PathVariable("id") int id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        return result;
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") int id) {
        return "消费端80，对方支付系统繁忙，请稍后再试！";
    }

    public String global_FallbackMethod() {
        return "全局异常处理，消费端80，对方支付系统繁忙，请稍后再试！";
    }
}
