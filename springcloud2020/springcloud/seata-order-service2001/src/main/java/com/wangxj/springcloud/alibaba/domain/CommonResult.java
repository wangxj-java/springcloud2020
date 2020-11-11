package com.wangxj.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangxj
 * @date 2020/5/10 13:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private String code ;
    private String message ;
    private T data ;

    public CommonResult(String code,String message){
        this(code,message,null);
    }

}
