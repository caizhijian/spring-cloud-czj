package com.czj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
 *
 * @Author:caizhijian
 * @Date:2020-03-16
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.czj")
public class SpringCloudEclientApp {

    public static void main(String[] args){
        SpringApplication.run(SpringCloudEclientApp.class,args);
    }
}
