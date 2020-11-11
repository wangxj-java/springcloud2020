package com.wangxj.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;
    @RequestMapping("/payment/consul")
    public String paymentZk(){
        return "springCloud with consul port: "+port+"\t"+ UUID.randomUUID().toString();
    }
}
