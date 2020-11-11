package com.wangxj.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxj
 * @date 2020/5/5 16:51
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort ;

    @Value("${config.info}")
    private String configInfo ;

    @GetMapping("/config/info")
    public String getInfo(){
        return configInfo ;
    }
}
