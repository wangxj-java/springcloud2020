package com.wangxj.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author wangxj
 * @date 2020/5/7 19:48
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){

        return "---testA      ---" ;
    }

    @GetMapping("/testB")
    public String testB(){
        return "---testB      ---" ;
    }

    @GetMapping("/testD")
    public String testD(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "---testD     ---" ;
    }

    @GetMapping("/testE")
    public String testE(){
        //测试异常次数,进行服务熔断
        int age = 10/0 ;
        return "---testE ---" ;
    }
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false)String P1,
                              @RequestParam(value = "p2",required = false)String p2){

        return  "testHotKey" ;
    }
    //自定义熔断响应信息
    public String deal_testHotKey(String p1, String p2 , BlockException b){

        return "deal_testHotKey" ;
    }
}
