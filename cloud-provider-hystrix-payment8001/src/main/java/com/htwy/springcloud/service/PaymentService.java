package com.htwy.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Vv
 * @title: PaymentService
 * @description: TODO
 * @date 2022/1/312:01 下午
 */
@Service
public class PaymentService {
    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(int id) {
        return "线程池：" + Thread.currentThread().getName() + "  id:" + id;
    }

    /**
     * 异常情况
     * 异常或超时都会进入fallback方法中paymentInfo_TimeOutHandler
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(int id) {
        int timeNumber = id;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "  id:" + id + "\t" + "耗时" + id + "秒";
    }

    public String paymentInfo_TimeOutHandler(int id) {
        return "失败，线程池：" + Thread.currentThread().getName() + "  id:" + id + "\t" + "服务端默认返回；";
    }
}
