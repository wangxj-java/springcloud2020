package com.wangxj.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author wangxj
 * @date 2020/5/10 17:18
 */
@Mapper
public interface AccountDao {

    void decrease(@Param("userId")Long userId, @Param("money")BigDecimal money);
}
