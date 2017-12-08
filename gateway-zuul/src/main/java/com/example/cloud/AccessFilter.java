package com.example.cloud;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * filterType：该函数需要返回一个字符串来代表过滤器的类型，而这个类型就是在HTTP请求过程中定义的各个阶段。在Zuul中默认定义了四种不同生命周期的过滤器类型，具体如下：
 * 1. pre：可以在请求被路由之前调用。
 * 2. routing：在路由请求时候被调用。
 * 3. post：在routing和error过滤器之后被调用。
 * 4. error：处理请求时发生错误时被调用。
 * <p>
 * filterOrder：通过int值来定义过滤器的执行顺序，数值越小优先级越高。
 * shouldFilter：返回一个boolean类型来判断该过滤器是否要执行。我们可以通过此方法来指定过滤器的有效范围。
 * run：过滤器的具体逻辑。在该函数中，我们可以实现自定义的过滤逻辑，来确定是否要拦截当前的请求，不对其进行后续的路由，或是在请求路由返回结果之后，对处理结果做一些加工等。
 *
 * @author yuweijun 2017-11-15.
 */
@Component
public class AccessFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccessFilter.class);

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
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        LOGGER.info("request url : {}", request.getRequestURL());
        Object accessToken = request.getParameter("test");
        if (accessToken != null) {
            LOGGER.warn("refuse access for testing access");
            ctx.setResponseStatusCode(401);
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("illegal request");
            return null;
        }
        LOGGER.info("request passed");
        return null;
    }

}