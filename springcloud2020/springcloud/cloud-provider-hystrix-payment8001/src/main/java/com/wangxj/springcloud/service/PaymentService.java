package com.wangxj.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfo_Ok(String id){
        return "线程池:  "+Thread.currentThread().getName()+"  paymentInfo_Ok,  id: "+id+"\t"+"O(∩_∩)O哈哈~" ;
    }

    /**
     * 服务降级
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
        @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
    })
    public String paymentInfo_TimeOut(String id){
        try {
            int number = 3 ;
            TimeUnit.SECONDS.sleep(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  "+Thread.currentThread().getName()+"  paymentInfo_TimeOut,  id: "+id+"\t"+"┭┮﹏┭┮" ;
    }

    public String paymentInfo_TimeOutHandler(String id){
        return "线程池:  "+Thread.currentThread().getName()+"  paymentInfo_TimeOutHandler,  id: "+id+"\t"+"┭┮﹏┭┮" ;
    }

    /**
     * 服务熔断
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreak_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60") //失败率达到多少后断路
    })
    public String paymentCircuitBreak(String id){
        if(Integer.parseInt(id)<0){
            throw new RuntimeException("---------id 不能小于0--");
        }
        String s = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"  调用成功,流水号: "+s;
    }

    public String paymentCircuitBreak_fallback(String id) {
        return "--id 不能小于0,请稍后再试!!!!";
    }
}
