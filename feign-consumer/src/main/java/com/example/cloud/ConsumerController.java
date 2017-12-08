package com.example.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuweijun 2017-11-13
 */
@RestController
public class ConsumerController {

    @Autowired
    private GreetingClient greetingClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String message) {
        return greetingClient.hello(message);
    }

}
