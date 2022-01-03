package com.htwy.springcloud.service;

import com.htwy.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Vv
 * @title: PaymentFeignService
 * @description: TODO
 * @date 2021/12/298:08 下午
 */
@Component
@FeignClient(value = "cloud-payment-service")
public interface OrderFeignService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();
}
