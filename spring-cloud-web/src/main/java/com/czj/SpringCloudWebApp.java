package com.czj;

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
public class SpringCloudWebApp {
    public static void main(String[] args){

        SpringApplication.run(SpringCloudWebApp.class,args);
    }
}
