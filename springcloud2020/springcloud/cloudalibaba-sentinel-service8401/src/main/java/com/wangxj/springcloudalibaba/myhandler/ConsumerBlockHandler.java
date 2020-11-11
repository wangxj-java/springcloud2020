package com.wangxj.springcloudalibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wangxj.springcloud.entity.CommonResult;

/**
 * @author wangxj
 * @date 2020/5/9 21:20
 */
public class ConsumerBlockHandler {

    public static CommonResult handlerException(BlockException e){

        return new CommonResult("444","按consumerBlockHandler  global测试------1");
    }

    public static CommonResult handlerException2(BlockException e){

        return new CommonResult("444","按consumerBlockHandler  global测试------2");
    }
}
