package com.htwy.springcloud.controller.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Vv
 * @title: FeignConfig
 * @description: TODO
 * @date 2021/12/299:00 下午
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        //配置fegin日志级别
        //默认 NONE 不限时任何日志
        //BASIC 仅记录请求方法、URL、响应状态码和执行时间
        //HEADERS: 除BASIC中的信息外，还有请求和响应头信息
        //FULL: 除连HEADERS中定义的信息外，还有请求及响应的正文及元数据
        return Logger.Level.FULL;
    }
}
