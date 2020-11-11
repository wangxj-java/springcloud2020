package com.wangxj.springcloud.dao;

import com.wangxj.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PaymentDao {

    public void save(Payment payment);
    public Payment findById(@Param("id") String id);
}
