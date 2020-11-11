package com.wangxj.springcloud.service;

import com.wangxj.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public void save(Payment payment);
    public Payment findById(@Param("id") String id);
}
