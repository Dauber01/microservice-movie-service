package com.example.microservicegatewayzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * 增加新的过滤器
 * @author Lucifer
 * @date 2018／04／07 16:28
 */
@Slf4j
public class PreRequestLogFilter extends ZuulFilter{

    @Override
    public String filterType() {
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
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        PreRequestLogFilter.log.info(String.format("send %s request to %s",
                request.getMethod(), request.getRequestURL().toString()));
        return null;
    }
}
