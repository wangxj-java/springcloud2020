package com.wangxj.springcloud.controller;


import com.wangxj.springcloud.entity.CommonResult;
import com.wangxj.springcloud.entity.Payment;
import com.wangxj.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort ;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/save")
    public CommonResult save(@RequestBody Payment payment){
        payment.setId(UUID.randomUUID().toString());
        paymentService.save(payment);
        return new CommonResult("200","插入成功 "+serverPort,payment);
    }

    @GetMapping("/payment/findById/{id}")
    public CommonResult findById(@PathVariable("id") String id){
        Payment payment = paymentService.findById(id);
        if(payment!=null){
            return new CommonResult("200","查询成功"+serverPort,payment);
        }  else{
            return new CommonResult("500","查询失败",null);}
    }
    @GetMapping("/payment/discovery")
    public Object discovery(){
        //获取服务清单
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("******service="+service+"**********");
        }

        //根据实列获取详细信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient ;
    }
    @GetMapping("/payment/lb")
    public String getPaymentLB(){

        return serverPort ;
    }

    //测试feign超时
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort ;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "hi ,i am paymentZipkin O(∩_∩)O哈哈~";
    }

}
