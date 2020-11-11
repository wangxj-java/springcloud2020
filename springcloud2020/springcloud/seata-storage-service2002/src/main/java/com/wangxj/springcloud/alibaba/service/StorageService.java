package com.wangxj.springcloud.alibaba.service;

/**
 * @author wangxj
 * @date 2020/5/10 17:02
 */
public interface StorageService {
    void decrease(Long productId,Integer count);
}
