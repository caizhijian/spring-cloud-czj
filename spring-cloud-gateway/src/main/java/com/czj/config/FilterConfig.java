package com.czj.config;

import com.czj.filter.ErrorFilter;
import com.czj.filter.IpFilter;
import com.czj.filter.SecondFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @Author:caizhijian
 * @Date:2020-03-25
 */
@Configuration
public class FilterConfig {

    @Bean
    public IpFilter ipFilter() {
        return new IpFilter();
    }

    @Bean
    public SecondFilter secondFilter() {
        return new SecondFilter();
    }

    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
}
