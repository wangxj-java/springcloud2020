package com.wangxj.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wangxj.springcloud.entity.CommonResult;
import com.wangxj.springcloud.entity.Payment;
import com.wangxj.springcloudalibaba.myhandler.ConsumerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxj
 * @date 2020/5/9 21:01
 */
@RestController
public class RateLimitController {


    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handlerException")
    public CommonResult byResource(){

        return new CommonResult("200","按资源名称限流测试",new Payment("2000","21830291"));
    }

    public CommonResult handlerException(BlockException e){

        return new CommonResult("400",e.getClass().getCanonicalName()+"\t服务不可用");
    }
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){

        return new CommonResult("200","按url限流测试",new Payment("2000","21830291"));
    }

    @GetMapping("/rateLimit/consumerBlockHandler")
    @SentinelResource(value = "consumerBlockHandler",
            blockHandlerClass = ConsumerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult consumerBlockHandler(){

        return new CommonResult("200","按consumerBlockHandler测试",new Payment("2000","21830291"));
    }
}
