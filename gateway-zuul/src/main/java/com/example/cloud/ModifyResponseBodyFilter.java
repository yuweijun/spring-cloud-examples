package com.example.cloud;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;
import static org.springframework.util.ReflectionUtils.rethrowRuntimeException;

/**
 * @author Spencer Gibb
 */
public class ModifyResponseBodyFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 999;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = getCurrentContext();
        return context.getRequest().getParameter("service") == null;
    }

    @Override
    public Object run() {
        try {
            RequestContext context = getCurrentContext();
            InputStream stream = context.getResponseDataStream();
            String body = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
            context.setResponseBody("Modified via setResponseBody(): " + body);
        } catch (IOException e) {
            rethrowRuntimeException(e);
        }
        return null;
    }
}
