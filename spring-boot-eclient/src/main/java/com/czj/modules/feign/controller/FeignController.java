package com.czj.modules.feign.controller;

import com.czj.modules.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 测试Feign
 * @Author:caizhijian
 * @Date:2020-03-19
 */
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private FeignService feignService;
    
    @GetMapping("/feignHello")
    public String feignHello(){
        String hello = feignService.feignHello();
        System.out.println("feignHello:"+hello);
        return hello;
    }
}
