package com.wangxj.springcloud.service;

import com.wangxj.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/findById/{id}")
    public CommonResult findById(@PathVariable("id") String id);
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut();
}
