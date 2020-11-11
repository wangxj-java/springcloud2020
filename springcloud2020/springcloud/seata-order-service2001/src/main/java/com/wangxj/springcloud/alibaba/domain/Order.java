package com.wangxj.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author wangxj
 * @date 2020/5/10 13:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id ;
    private Long userId ;
    private Long productId ;
    private Integer count ;
    private BigDecimal money ;
    private Integer status ; //0:创建中, 1:已完结
}
