package com.czj.modules.feign.service;

import com.czj.config.FeignConfiguration;
import com.czj.config.UserRemoteClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * 测试Feign
 * @Author:caizhijian
 * @Date:2020-03-19
 */
@FeignClient(value = "spring-boot-web", path="/springbootweb", configuration = FeignConfiguration.class, fallbackFactory = UserRemoteClientFallbackFactory.class)
public interface FeignService {
    /**
     * 测试feign
     * @return
     */
    @GetMapping("/hello/sayHello")
    String feignHello();
}
