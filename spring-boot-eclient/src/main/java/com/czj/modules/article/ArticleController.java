package com.czj.modules.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/*
 * restTemplate
 * @Author:caizhijian
 * @Date:2020-03-16
 */
@RestController
@RequestMapping(value = "/article")
public class ArticleController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/callHello")
    public String callHello() {
        System.out.println("callHello");
        return restTemplate.getForObject("http://localhost:8081/hello/sayHello", String.class);
    }

    @GetMapping("/callHello2")
    public String callHello2() {
        System.out.println("callHello2");
        return restTemplate.getForObject("http://spring-boot-web/hello/sayHello", String.class);
    }
}
