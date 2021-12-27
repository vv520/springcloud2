package com.htwy.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;

/**
 * @author Vv
 * @title: MyselfRule
 * @description: TODO
 * @date 2021/12/278:34 下午
 */
public class MyselfRule {
    @Bean
    public IRule getRule(){
        //return new RoundRobinRule(); //轮询 默认
        return new RandomRule(); //随机

    }
}
