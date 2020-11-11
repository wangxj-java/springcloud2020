package com.wangxj.springcloud.alibaba.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author wangxj
 * @date 2020/5/10 17:24
 */
public interface AccountService {

    void decrease(@RequestParam("userId")Long userId, @RequestParam("money")BigDecimal money);
}
