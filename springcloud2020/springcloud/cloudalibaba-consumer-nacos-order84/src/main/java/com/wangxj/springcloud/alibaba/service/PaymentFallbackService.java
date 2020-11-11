package com.wangxj.springcloud.alibaba.service;

import com.wangxj.springcloud.entity.CommonResult;
import com.wangxj.springcloud.entity.Payment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wangxj
 * @date 2020/5/9 22:56
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(@PathVariable("id") String id) {
        return new CommonResult<>("500","服务降级",new Payment(id,"error"));
    }
}
