package com.wangxj.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxj
 * @date 2020/5/5 15:57
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort ;

    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") String id){
        //System.out.println("nacos is registry ,serverPort: " + serverPort + "\t" + " id: " + id);
        return "nacos is registry ,serverPort: " + serverPort + "\t" + " id: " + id ;
    }
}
