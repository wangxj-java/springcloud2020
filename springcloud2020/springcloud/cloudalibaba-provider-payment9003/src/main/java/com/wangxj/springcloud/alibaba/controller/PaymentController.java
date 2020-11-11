package com.wangxj.springcloud.alibaba.controller;

import com.wangxj.springcloud.entity.CommonResult;
import com.wangxj.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author wangxj
 * @date 2020/5/9 21:46
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort ;

    public static HashMap<String, Payment> hashMap = new HashMap<String,Payment>();
    static {
        hashMap.put("1",new Payment("111","1111111111"));
        hashMap.put("2",new Payment("222","2222222222"));
        hashMap.put("3",new Payment("333","3333333333"));
    }

    @GetMapping("/paymentBySql/{id}")
    public CommonResult<Payment> paymentBySql(@PathVariable("id")String id){
        Payment payment = hashMap.get(id);
        return new CommonResult("200","查询成功 serverPort: "+serverPort,payment);
    }
}
