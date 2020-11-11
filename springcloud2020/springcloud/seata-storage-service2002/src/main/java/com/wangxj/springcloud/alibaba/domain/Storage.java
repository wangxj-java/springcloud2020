package com.wangxj.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangxj
 * @date 2020/5/10 16:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    private Long id ;
    private Long productId ;
    private Integer total ;
    private Integer used ;
    private Integer residue ;

}
