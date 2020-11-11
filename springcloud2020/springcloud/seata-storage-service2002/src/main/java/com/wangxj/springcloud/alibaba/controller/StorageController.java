package com.wangxj.springcloud.alibaba.controller;

import com.wangxj.springcloud.alibaba.domain.CommonResult;
import com.wangxj.springcloud.alibaba.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangxj
 * @date 2020/5/10 17:06
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService ;

    @PostMapping("/storage/decrease")
    public CommonResult decrease(@RequestParam("productId")Long productId, @RequestParam("count")Integer count){
        storageService.decrease(productId,count);
        return new CommonResult("200","扣减库存成功");
    }

}
