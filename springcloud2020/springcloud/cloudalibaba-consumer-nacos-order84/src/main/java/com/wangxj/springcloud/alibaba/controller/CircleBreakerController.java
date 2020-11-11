package com.wangxj.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wangxj.springcloud.alibaba.service.PaymentService;
import com.wangxj.springcloud.entity.CommonResult;
import com.wangxj.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author wangxj
 * @date 2020/5/9 22:06
 */
@RestController
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate ;

    @Resource
    private PaymentService paymentService ;

    @GetMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback")//没有配置
    //@SentinelResource(value = "fallback",fallback = "handlerBlock")//只负责java代码业务异常
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler")//blockHandler负责sentinel控制台配置违规
    @SentinelResource(value = "fallback",blockHandler = "blockHandler",fallback = "handlerBlock")//两个都配置,sentinel优先管控
    public CommonResult<Payment> fallBack(@PathVariable("id") String id){
        CommonResult forObject = restTemplate.getForObject(SERVICE_URL + "/paymentBySql/" + id, CommonResult.class, id);
        if("4".equals(id)){
            throw new IllegalArgumentException("非法参数异常");
        }else if(forObject.getData()==null){
            throw new NullPointerException("该id没有对应的记录");
        }
        return forObject ;
    }

    //@SentinelResource(value = "fallback",fallback = "handlerBlock")
    public CommonResult handlerBlock(@PathVariable("id")String id,Throwable e){
        Payment aNull = new Payment(id, "null");
        return new CommonResult("500","兜底异常杨冬冬我爱你异常"+e.getMessage(),aNull);
    }

    //@SentinelResource(value = "fallback",blockHandler = "blockHandler")
    public CommonResult blockHandler(@PathVariable("id")String id, BlockException e){
        Payment aNull = new Payment(id, "null");
        return new CommonResult("500","blockHandler-sentinel异常 "+e.getMessage(),aNull);
    }

    //feign
    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentFeign(@PathVariable("id")String id){
        CommonResult<Payment> paymentCommonResult = paymentService.paymentSQL(id);
        return paymentCommonResult ;
    }
}
