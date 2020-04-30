package com.czj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 定时器模块练习
 * @Author caizhijian
 * @create 2020/4/30
 */
@EnableScheduling
@SpringBootApplication
public class TaskApp {

    public static void main(String[] args){

        SpringApplication.run(TaskApp.class,args);
    }

}
