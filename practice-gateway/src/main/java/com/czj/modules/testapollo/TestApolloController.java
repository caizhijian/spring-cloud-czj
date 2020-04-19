package com.czj.modules.testapollo;

import com.czj.config.ApolloConfigValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:caizhijian
 * @Date:2020-04-19
 */
@RestController
@RequestMapping("/test")
public class TestApolloController {

    @Autowired
    private ApolloConfigValue apolloConfigValue;
    
    @GetMapping
    @RequestMapping("/getApolloConfigValue")
    public String getApolloConfigValue(String key) {

        return apolloConfigValue.getTestapollo1();
    }

}
