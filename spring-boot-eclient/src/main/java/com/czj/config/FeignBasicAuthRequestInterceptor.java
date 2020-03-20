package com.czj.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Feign拦截器
 * @Author caizhijian
 * @create 2020/3/20
 */
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor{

    @Override
    public void apply(RequestTemplate requestTemplate) {
        
        System.out.println("进入拦截器，获取请求头数据");
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return;
        }

        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
		
        String userCode = request.getHeader("x-tif-uid");
        requestTemplate.header("x-tif-uid", userCode);
    }

}
