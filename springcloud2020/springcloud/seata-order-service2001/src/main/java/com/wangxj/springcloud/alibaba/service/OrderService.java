package com.wangxj.springcloud.alibaba.service;

import com.wangxj.springcloud.alibaba.domain.Order;

/**
 * @author wangxj
 * @date 2020/5/10 14:00
 */
public interface OrderService {

    void create(Order order);

    void update();
}
