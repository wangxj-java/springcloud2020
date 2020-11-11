package com.wangxj.springcloud.controller;

import com.wangxj.springcloud.entity.CommonResult;
import com.wangxj.springcloud.entity.Payment;
import com.wangxj.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService ;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") String id){
        return paymentFeignService.findById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        //openfeign 默认一秒钟拿到结果
        return paymentFeignService.paymentFeignTimeOut();
    }
}
