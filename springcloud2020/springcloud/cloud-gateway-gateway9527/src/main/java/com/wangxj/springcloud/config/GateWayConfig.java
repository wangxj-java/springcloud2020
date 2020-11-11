package com.wangxj.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangxj
 * @date 2020/5/3 12:50
 */
@Configuration
public class GateWayConfig {
    //自定义路由网关
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //https://news.baidu.com/lady  百度新闻
        //访问/lady, 网关路由到https://news.baidu.com/lady
        routes.route("path_baidu_news",
                r -> r.path("/lady").uri("https://news.baidu.com/lady"));
        return routes.build();
    }
}
