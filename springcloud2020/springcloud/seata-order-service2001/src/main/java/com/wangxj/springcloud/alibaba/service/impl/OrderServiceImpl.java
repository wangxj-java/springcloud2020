package com.wangxj.springcloud.alibaba.service.impl;

import com.wangxj.springcloud.alibaba.dao.OrderDao;
import com.wangxj.springcloud.alibaba.domain.Order;
import com.wangxj.springcloud.alibaba.service.AccountService;
import com.wangxj.springcloud.alibaba.service.OrderService;
import com.wangxj.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wangxj
 * @date 2020/5/10 14:02
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao ;

    @Resource
    private StorageService storageService ;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "sfp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        System.out.println("--------1.开始新建订单-------");
        orderDao.create(order);

        System.out.println("------2.订单微服务开始调用存库,做扣减-Count-start");
        storageService.decrease(order.getProductId(),order.getCount());
        System.out.println("------2.订单微服务开始调用存库,做扣减-Count-end");

        System.out.println("------3.订单微服务开始调用账户,做扣减-Money-start");
        accountService.decrease(order.getUserId(),order.getMoney());
        System.out.println("------3.订单微服务开始调用账户,做扣减-Money-end");

        System.out.println("------4.订单微服务开始调用订单,修改状态到1已完结-start");
        orderDao.update(order.getUserId(),0);
        System.out.println("------4.订单微服务开始调用订单,修改状态到1已完结-end");
        System.out.println("--------5.下订单结束了 哈哈哈哈-------");
    }

    @Override
    public void update() {

    }
}
