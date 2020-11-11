package com.wangxj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wangxj
 * @date 2020/5/1 14:47
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OderFeignHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OderFeignHystrixMain80.class,args);
    }
}
