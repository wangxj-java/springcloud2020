package com.wanxj.springcloud.controller;

import com.wangxj.springcloud.entity.CommonResult;
import com.wangxj.springcloud.entity.Payment;
import com.wanxj.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
public class OrderController {
    //public static final String PAYMENT_URL = "http://127.0.0.1:8001" ;
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE" ;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer ;

    @Resource
    private DiscoveryClient discoveryClient ;

    @GetMapping("/consumer/payment/save")
    public ResponseEntity<CommonResult> save(Payment payment){
        return restTemplate.postForEntity(PAYMENT_URL+"/payment/save",payment,CommonResult.class);

    }
    @GetMapping("/consumer/payment/get/{id}")
    public ResponseEntity<CommonResult> getPayment(@PathVariable("id")String id ){
        return restTemplate.getForEntity(PAYMENT_URL+"/payment/findById/"+id,CommonResult.class);

    }

    @GetMapping("/consumer/payment/getEntity/{id}")
    public CommonResult getPayment2(@PathVariable("id")String id ){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/findById/" + id, CommonResult.class);
        if(forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else{
            return new CommonResult("500","操作失败");
        }

    }
    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size()<=0){
            return null ;
        }
        ServiceInstance serviceInstance = loadBalancer.instance(instances) ;
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);

    }
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin(){
        String forObject = restTemplate.getForObject( PAYMENT_URL+"/payment/zipkin", String.class);
        return forObject ;
    }

}
