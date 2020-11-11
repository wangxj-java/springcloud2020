package com.wangxj.springcloud.alibaba.dao;

import com.wangxj.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wangxj
 * @date 2020/5/10 13:26
 */
@Mapper
public interface OrderDao {
    //1 新建订单
    void create(Order order);

    //2 修改订单状态从0 -> 1
    void update(@Param("userId")Long userId,@Param("status")Integer status);
}
