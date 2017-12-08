package com.example.cloud;

import org.springframework.stereotype.Component;

/**
 * @author yuweijun 2017-11-14
 */
@Component
public class GreetingClientHystrix implements GreetingClient {

    @Override
    public String hello(String message) {
        return "fall back message from : " + GreetingClientHystrix.class.getSimpleName();
    }

    @Override
    public String rand() {
        return "fall back rand from : " + GreetingClientHystrix.class.getSimpleName();
    }

}
