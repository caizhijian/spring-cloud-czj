package com.czj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * zuul学习
 * @Author:caizhijian
 * @Date:2020-03-25
 */
@EnableZuulProxy
@SpringBootApplication
public class SpringCloudGatewayApp {
    public static void main(String[] args){
        SpringApplication.run(SpringCloudGatewayApp.class,args);
    }
}
