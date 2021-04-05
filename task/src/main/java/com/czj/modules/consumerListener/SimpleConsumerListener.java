package com.czj.modules.consumerListener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author:caizhijian
 * @Date:2021-04-05
 * @describe kafka消费监听器
 */
@Component
public class SimpleConsumerListener {
    @KafkaListener(id = "demo", topics = "test")
    public void listen(String input) {
        System.out.println("input:"+input);
    }
}
