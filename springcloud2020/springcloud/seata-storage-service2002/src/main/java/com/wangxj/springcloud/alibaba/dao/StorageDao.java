package com.wangxj.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wangxj
 * @date 2020/5/10 16:53
 */
@Mapper
public interface StorageDao {

    void decrease(@Param("productId")Long productId,@Param("count")Integer count);
}
