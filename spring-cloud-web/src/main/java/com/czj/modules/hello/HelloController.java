package com.czj.modules.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *
 * @Author:caizhijian
 * @Date:2020-03-16
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @GetMapping("/sayHello")
    public String hello(){
        int i = 1/0;
        System.out.println(i);
        return "hello";
    }
}
