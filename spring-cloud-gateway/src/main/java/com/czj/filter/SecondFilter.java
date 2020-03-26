package com.czj.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @Author:caizhijian
 * @Date:2020-03-26
 */
public class SecondFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        //判断是否执行过滤器
        RequestContext ctx = RequestContext.getCurrentContext();
        Object success = ctx.get("result");
        return success == null ? true : Boolean.parseBoolean(success.toString());
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("进入第二个过滤器");
        return null;
    }
}
