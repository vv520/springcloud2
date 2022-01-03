package com.htwy.springcloud.controller;

import com.htwy.springcloud.entity.CommonResult;
import com.htwy.springcloud.entity.Payment;
import com.htwy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*******插入结果{}", result);
        //Log.info;
        if(result > 0){
            return new CommonResult(200, "数据插入成功" + serverPort, result);
        }else {
            return new CommonResult(444, "数据插入失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        //Log.info;
        if(payment != null){
            return new CommonResult(200, "查询成功" + serverPort, payment);
        }else {
            return new CommonResult(444, "没有对应记录，查询Id:" + id, null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        //获取所有注册进eureka中的服务
        List<String> list = discoveryClient.getServices();
        for(String element : list){
            log.info("****element:" + element);
        }
        //通过名称获取服务 spring.application.name配置项
        List<ServiceInstance> srvList = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance element : srvList) {
            log.info(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }
}
