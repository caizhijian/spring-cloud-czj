package com.czj.modules.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.kafka.core.KafkaTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * 接口测试类
 * @Author:caizhijian
 * @Date:2020-03-16
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @GetMapping("/sayHello")
    public String hello(HttpServletRequest request){
        //测试请求头
        System.out.println(request.getHeader("X-Request-Foo"));
        return "hello";
    }

    @GetMapping("/testKafka/{input}")
    public String sendFoo(@PathVariable String input) {
        this.template.send("test", input);
        return "testKafka";
    }


}
