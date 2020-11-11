package com.wangxj.springcloud.alibaba.service;

import com.wangxj.springcloud.entity.CommonResult;
import com.wangxj.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wangxj
 * @date 2020/5/9 22:50
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping("/paymentBySql/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id")String id);
}
