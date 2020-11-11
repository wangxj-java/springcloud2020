package com.wangxj.springcloud.controller;


import com.wangxj.springcloud.entity.CommonResult;
import com.wangxj.springcloud.entity.Payment;
import com.wangxj.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort ;

    @PostMapping("/payment/save")
    public CommonResult save(@RequestBody Payment payment){
        payment.setId(UUID.randomUUID().toString());
        paymentService.save(payment);
        return new CommonResult("200","插入成功"+serverPort,payment);
    }

    @GetMapping("/payment/findById/{id}")
    public CommonResult findById(@PathVariable("id") String id){
        Payment payment = paymentService.findById(id);
        if(payment!=null){
            return new CommonResult("200","查询成功"+serverPort,payment);
        }  else{
            return new CommonResult("500","查询失败",null);}
    }

    @GetMapping("payment/lb")
    public String getPaymentLB(){

        return serverPort ;
    }
}
