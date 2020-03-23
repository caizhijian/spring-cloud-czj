package com.czj.config;

import com.czj.modules.feign.service.FeignService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 服务熔断时，进入方法
 * @Author:caizhijian
 * @Date:2020-03-23
 */
@Component
public class UserRemoteClientFallbackFactory implements FallbackFactory<FeignService> {
    private Logger logger = LoggerFactory.getLogger(UserRemoteClientFallbackFactory.class);

    @Override
    public FeignService create(Throwable throwable) {
        logger.error("UserRemoteClient回退：", throwable);
        return new FeignService() {
            @Override
            public String feignHello() {
                return "fail";
            }
        };
    }

}
