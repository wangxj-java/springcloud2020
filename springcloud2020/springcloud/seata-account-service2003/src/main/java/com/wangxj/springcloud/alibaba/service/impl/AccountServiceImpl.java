package com.wangxj.springcloud.alibaba.service.impl;

import com.wangxj.springcloud.alibaba.dao.AccountDao;
import com.wangxj.springcloud.alibaba.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author wangxj
 * @date 2020/5/10 17:25
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao ;
    @Override
    public void decrease(Long userId, BigDecimal money) {
        System.out.println("账户余额开始扣减");
        //int aga = 10/0 ;
        accountDao.decrease(userId,money);
        System.out.println("账户余额结束扣减");
    }
}
