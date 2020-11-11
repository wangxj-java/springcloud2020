package com.wangxj.springcloud.alibaba.service.impl;

import com.wangxj.springcloud.alibaba.dao.StorageDao;
import com.wangxj.springcloud.alibaba.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wangxj
 * @date 2020/5/10 17:03
 */
@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao ;

    @Override
    public void decrease(Long productId, Integer count) {
        System.out.println("-------------库存扣减开始----------");
        storageDao.decrease(productId,count);
        System.out.println("-------------库存扣减结束----------");
    }
}
