package com.czj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
 *
 * @Author:caizhijian
 * @Date:2020-03-16
 */
@EnableEurekaServer
@SpringBootApplication
public class SpringCoudEureka {
    public static void main(String[] args){
        SpringApplication.run(SpringCoudEureka.class);
    }
}
