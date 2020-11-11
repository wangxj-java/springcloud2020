package com.wangxj.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wangxj.springcloud.service.OderFeignHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangxj
 * @date 2020/5/1 14:53
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_global_fallbackMethod")
public class OderHystrixController {
    @Resource
    private OderFeignHystrixService oderFeignHystrixService ;

    @GetMapping("/order/hystrix/ok/{id}")
    public String getInfo_Ok(@PathVariable("id") String id){
        return  oderFeignHystrixService.paymentInfo_Ok(id);
    }

    @GetMapping("/order/hystrix/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "getInfo_timeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })*/
    @HystrixCommand
    public String getInfo_timeout(@PathVariable("id") String id){
        int age = 10/0 ;
        return  oderFeignHystrixService.paymentInfo_TimeOut(id);
    }
    public String getInfo_timeoutHandler(@PathVariable("id") String id){
        return Thread.currentThread().getName()+"我是消费80,  编号:"+id+", 我等不起了,拜拜了您嘞!" ;
    }

    //global 全局fallbackMethod;
    public String payment_global_fallbackMethod(){

        return "欢迎来到全局异常处理界面.---------------";
    }

}
