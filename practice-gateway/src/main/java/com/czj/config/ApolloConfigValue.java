package com.czj.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author:caizhijian
 * @Date:2020-04-19
 */
@Configuration
@Component
@Data
public class ApolloConfigValue {

    @Value("${testapollo1}")
    private String testapollo1;

    @Value("${testapollo2.testapollo2_1}")
    private String testapollo2_1;

    @Value("${testapollo2.testapollo2_2}")
    private String testapollo2_2;

    private String name = "name";
}
