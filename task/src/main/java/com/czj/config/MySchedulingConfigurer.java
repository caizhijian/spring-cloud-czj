package com.czj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.IntervalTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.Date;

/**
 * 定时任务配置类
 * @Author caizhijian
 * @create 2020/4/30
 */
@Configuration
public class MySchedulingConfigurer implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setTaskScheduler(poolScheduler());
        // add job
        taskRegistrar.addFixedRateTask(new IntervalTask(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Job @ fixed rate " + new Date() + ", Thread name is " + Thread.currentThread().getName());
                    }
                }, 2000, 0));
    }

    @Bean
    public TaskScheduler poolScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("poolScheduler");
        scheduler.setPoolSize(10);
        return scheduler;
    }

}
