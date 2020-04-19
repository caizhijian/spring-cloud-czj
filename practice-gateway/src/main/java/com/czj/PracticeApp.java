package com.czj;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author:caizhijian
 * @Date:2020-03-29
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableApolloConfig
public class PracticeApp {

    public static void main(String[] args){
        SpringApplication.run(PracticeApp.class,args);
    }

}
