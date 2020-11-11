package com.wangxj.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author wangxj
 * @date 2020/5/5 16:20
 */
@RestController
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate ;
    @Value("${server-url.nacos-user-service}")
    private String serverURL ;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String getPaymentInfo(@PathVariable("id") String id){
        return restTemplate.getForObject(serverURL+"/payment/nacos/"+id,String.class) ;
    }
}
