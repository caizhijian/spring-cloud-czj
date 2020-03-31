package com.czj.modules.testgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:caizhijian
 * @Date:2020-03-29
 */
@RestController
@RequestMapping("/test-gateWay")
public class TestGateWayController {

    @GetMapping("/hello/sayHello")
    public String test(){
        return "123";
    }
}
