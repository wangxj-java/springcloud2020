package com.wangxj.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author wangxj
 * @date 2020/5/2 23:41
 */
@Component
public class OrderFeignHystrixFallbackService implements OderFeignHystrixService {
    @Override
    public String paymentInfo_Ok(String id) {
        return "--------OrderFeignHystrixFallbackService fall back paymentInfo_Ok" ;
    }

    @Override
    public String paymentInfo_TimeOut(String id) {
        return "----------OrderFeignHystrixFallbackService fall back paymentInfo_TimeOut" ;
    }
}
