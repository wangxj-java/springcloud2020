package com.wangxj.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxj
 * @date 2020/5/4 15:59
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${server.port}")
    private String serverPort ;

    @Value("${config.info}")
    private String configInfo ;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return "端口: "+serverPort+"  信息:"+configInfo ;
    }
}

