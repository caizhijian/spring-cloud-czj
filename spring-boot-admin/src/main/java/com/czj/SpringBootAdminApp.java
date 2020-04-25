package com.czj;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springbootadmin启动类
 * @Author:caizhijian
 * @Date:2020-04-25
 */
@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
public class SpringBootAdminApp {

    public static void main(String[] args){

        SpringApplication.run(SpringBootAdminApp.class,args);
    }

}
