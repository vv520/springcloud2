package com.htwy.springcloud.controller;

import com.htwy.springcloud.entity.CommonResult;
import com.htwy.springcloud.entity.Payment;
import com.htwy.springcloud.service.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Vv
 * @title: OrderFeignController
 * @description: TODO
 * @date 2021/12/298:12 下午
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private OrderFeignService orderFeignService;

    @GetMapping(value = "/feign/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return orderFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout(){
        return orderFeignService.paymentFeignTimeout();
    }
}
