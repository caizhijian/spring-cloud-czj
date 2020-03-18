package com.czj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
 *
 * @Author:caizhijian
 * @Date:2020-03-18
 */
@EnableEurekaServer
@SpringBootApplication
public class SpringCloudCluster {
    public static void main(String[] args){
        SpringApplication.run(SpringCloudCluster.class,args);
    }
}
