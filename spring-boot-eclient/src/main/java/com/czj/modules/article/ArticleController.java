package com.czj.modules.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/*
 *
 * @Author:caizhijian
 * @Date:2020-03-16
 */
@RestController
public class ArticleController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/article/callHello")
    public String callHello() {
        return restTemplate.getForObject("http://localhost:8083/hello", String.class);
    }
}
