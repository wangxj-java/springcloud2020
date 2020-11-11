package com.wangxj.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxj
 * @date 2020/5/3 22:47
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo ;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo ;
    }
}
