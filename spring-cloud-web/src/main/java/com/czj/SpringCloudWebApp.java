package com.czj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*
 * 启动类
 * @Author:caizhijian
 * @Date:2020-03-16
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.czj.modules")
public class SpringCloudWebApp {
    public static void main(String[] args){

        SpringApplication.run(SpringCloudWebApp.class,args);
    }
}
