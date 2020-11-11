package com.wangxj.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangxj
 * @date 2020/5/10 14:27
 */
@Configuration
@MapperScan("com.wangxj.springcloud.alibaba.dao")
public class MybatisConfig {

}
