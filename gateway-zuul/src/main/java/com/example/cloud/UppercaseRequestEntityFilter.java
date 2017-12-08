package com.example.cloud;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.util.StreamUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;
import static org.springframework.util.ReflectionUtils.rethrowRuntimeException;

/**
 * @author Spencer Gibb
 */
public class UppercaseRequestEntityFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 6;
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
            InputStream in = (InputStream) context.get("requestEntity");
            if (in == null) {
                in = context.getRequest().getInputStream();
            }
            String body = StreamUtils.copyToString(in, Charset.forName("UTF-8"));
            // body = "request body modified via set('requestEntity'): "+ body;
            body = body.toUpperCase();
            context.set("requestEntity", new ByteArrayInputStream(body.getBytes("UTF-8")));
        } catch (IOException e) {
            rethrowRuntimeException(e);
        }
        return null;
    }
}
