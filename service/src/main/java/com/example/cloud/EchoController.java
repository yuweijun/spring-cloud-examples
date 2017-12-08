package com.example.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author yuweijun 2017-11-13
 */
@RestController
public class EchoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EchoController.class);

    @RequestMapping("/echo")
    public String echo(String message) {
        LOGGER.info("request from client : {}", new Date());
        return message;
    }

    @RequestMapping("/rand")
    public String rand() throws InterruptedException {
        LOGGER.info("request from client : {}", new Date());
        long millis = System.currentTimeMillis();
        if (millis % 2 == 1) {
            TimeUnit.SECONDS.sleep(3);
            return "rand with sleep 3 seconds.";
        } else {
            return "rand without sleep.";
        }
    }

}
