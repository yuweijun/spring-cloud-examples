package com.example.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yuweijun 2017-11-13
 */
@FeignClient(value = "service-application")
public interface GreetingClient {

    /**
     * echo message to client
     * @param message receive from client
     */
    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    String hello(@RequestParam("message") String message);

    /**
     * rand sleep 3 seconds to client
     */
    @RequestMapping(value = "/rand", method = RequestMethod.GET)
    String rand();

}
