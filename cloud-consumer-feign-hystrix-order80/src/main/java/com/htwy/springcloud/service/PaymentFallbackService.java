package com.htwy.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author Vv
 * @title: PaymentFalbackService
 * @description: TODO
 * @date 2022/1/32:44 下午
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public String paymentInfo_OK(int id) {
        return "PaymentFallbackService:客户端fallback返回paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(int id) {
        return "PaymentFallbackService:客户端fallback返回paymentInfo_TimeOut";
    }
}
