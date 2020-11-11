package com.wangxj.springcloud.alibaba.controller;

import com.wangxj.springcloud.alibaba.domain.CommonResult;
import com.wangxj.springcloud.alibaba.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author wangxj
 * @date 2020/5/10 17:27
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService ;

    @PostMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId")Long userId, @RequestParam("money")BigDecimal money){
        accountService.decrease(userId,money);
        return new CommonResult("200","账户扣减成功");
    }
}
