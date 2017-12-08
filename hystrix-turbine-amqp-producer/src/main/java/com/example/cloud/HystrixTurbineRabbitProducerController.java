package com.example.cloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuweijun 2017-11-13
 */
@RestController
public class HystrixTurbineRabbitProducerController {

    @Autowired
    private GreetingClient greetingClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String message) {
        return greetingClient.hello(message);
    }

    /**
     * randFallback reference to method: private String {@link #randFallback()}
     */
    @HystrixCommand(fallbackMethod = "randFallback")
    @RequestMapping(value = "/rand", method = RequestMethod.GET)
    public String rand() {
        return greetingClient.rand();
    }

    /**
     * 上面rand方法超时2秒之后会被熔断器接管
     */
    private String randFallback() {
        return "rand fallback";
    }

}
