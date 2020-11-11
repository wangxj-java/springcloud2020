package com.wangxj.springcloud.alibaba.controller;

import com.wangxj.springcloud.alibaba.domain.CommonResult;
import com.wangxj.springcloud.alibaba.domain.Order;
import com.wangxj.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangxj
 * @date 2020/5/10 14:24
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService ;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult("200","订单创建成功!",order);
    }
}
