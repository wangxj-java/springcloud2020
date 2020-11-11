package com.wangxj.springcloud.controller;

import com.wangxj.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class paymentController {
    @Resource
    private PaymentService paymentService ;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable String id){
        return paymentService.paymentInfo_Ok(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable String id){
        return paymentService.paymentInfo_TimeOut(id);
    }

    //服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreak(@PathVariable("id") String id){
        return paymentService.paymentCircuitBreak(id);
    }

}
