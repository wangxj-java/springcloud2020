package com.wangxj.springcloud.service.impl;

import com.wangxj.springcloud.dao.PaymentDao;
import com.wangxj.springcloud.entity.Payment;
import com.wangxj.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public void save(Payment payment) {
        paymentDao.save(payment);
    }

    @Override
    public Payment findById(String id) {
        return paymentDao.findById(id);
    }
}
