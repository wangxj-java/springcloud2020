package com.wangxj.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author wangxj
 * @date 2020/5/10 17:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Long id ;
    private Long userId ;
    private BigDecimal total ;
    private BigDecimal used ;
    private BigDecimal residue ;
}
