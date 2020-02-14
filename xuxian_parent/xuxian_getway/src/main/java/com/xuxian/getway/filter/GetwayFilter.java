package com.xuxian.getway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class GetwayFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        System.out.println("经过getway过滤器");
        String headerToken = request.getHeader("AuthToken");
        if (headerToken != null && headerToken.startsWith("CeShi ")) {
//            context.addZuulRequestHeader("AuthToken",headerToken);
            context.setSendZuulResponse(true);
            context.setResponseStatusCode(200);
            context.set("isSuccess",true);
       }
//        else{
////            context.setSendZuulResponse(false);
////            context.setResponseStatusCode(401);
//        }
        return null;
    }
}
