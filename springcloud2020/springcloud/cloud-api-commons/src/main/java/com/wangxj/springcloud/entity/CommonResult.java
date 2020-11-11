package com.wangxj.springcloud.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T>{
    private String code ;
    private String message ;
    private T Data ;
    public CommonResult(String code, String message) {
        this(code,message,null);
    }
}
