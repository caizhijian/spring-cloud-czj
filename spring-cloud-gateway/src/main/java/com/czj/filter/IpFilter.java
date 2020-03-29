package com.czj.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.czj.common.IpUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.bouncycastle.asn1.ocsp.ResponseData;

import java.util.Arrays;
import java.util.List;

/**
 * zuul过滤器
 * @Author:caizhijian
 * @Date:2020-03-25
 */
public class IpFilter extends ZuulFilter {

    // IP黑名单列表
    private List<String> blackIpList = Arrays.asList("127.0.0.1");
    public IpFilter() {
        super();
    }

    @Override
    public String filterType() {
        //pre、route、post、error
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        String ip = IpUtils.getIpAddr(ctx.getRequest());
        // 在黑名单中禁用
        if (StringUtils.isNotBlank(ip) && blackIpList.contains(ip)) {
            ctx.setSendZuulResponse(false);
            //ResponseData data = ResponseData.("非法请求 ", "");
            JSONObject json = new JSONObject();
            json.put("code","401");
            json.put("message","非法请求");
            ctx.setResponseBody(json.toString());
            ctx.getResponse().setContentType("application/json; charset=utf-8");
            ctx.set("result",false);
            return null;
        }
        return null;
    }
}
