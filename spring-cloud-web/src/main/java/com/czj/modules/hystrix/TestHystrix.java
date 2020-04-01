package com.czj.modules.hystrix;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:caizhijian
 * @Date:2020-04-01
 */
@RestController
@RequestMapping("/testHystrix")
public class TestHystrix {

    @GetMapping("/test")
    public String test(){
        System.out.println("testHystrix");
        return "testHystrix";
    }
}
