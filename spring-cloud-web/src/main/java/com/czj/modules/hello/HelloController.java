package com.czj.modules.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 接口测试类
 * @Author:caizhijian
 * @Date:2020-03-16
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @GetMapping("/sayHello")
    public String hello(HttpServletRequest request){
        //测试请求头
        System.out.println(request.getHeader("X-Request-Foo"));;
        return "hello";
    }
}
