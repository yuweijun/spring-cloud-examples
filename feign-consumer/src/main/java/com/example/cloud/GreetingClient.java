package com.example.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yuweijun 2017-11-13
 */
@FeignClient("service-application")
public interface GreetingClient {

    /**
     * RequestMapping指向service-application中的请求地址，如果服务地址endpoint不存在
     * http请求会抛404，类似信息如下：
     * feign.FeignException: status 404 reading GreetingClient#hello(String); content:
     * {"timestamp":1510569441255,"status":404,"error":"Not Found","message":"No message available","path":"/"}
     */
    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    String hello(@RequestParam("message") String message);

}
