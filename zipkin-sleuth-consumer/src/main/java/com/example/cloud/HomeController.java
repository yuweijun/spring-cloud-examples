package com.example.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author yuweijun 2017-11-24.
 */
@RestController
class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/service1")
    public String service1() {
        LOGGER.info("service1");
        int sleep = randomSleepMillis();
        String result = this.restTemplate.getForObject("http://localhost:9872/service2", String.class);
        return " [service1 sleep " + sleep + " ms]" + result;
    }

    @RequestMapping("/service2")
    public String service2() {
        LOGGER.info("service2");
        int sleep = randomSleepMillis();
        String result = this.restTemplate.getForObject("http://localhost:9873/service3", String.class);
        return " [service2 sleep " + sleep + " ms]" + result;
    }

    @RequestMapping("/service3")
    public String service3() {
        LOGGER.info("service3");
        int sleep = randomSleepMillis();
        String result = this.restTemplate.getForObject("http://localhost:9874/service4", String.class);
        return " [service3 sleep " + sleep + " ms]" + result;
    }

    @RequestMapping("/service4")
    public String service4() {
        LOGGER.info("service4");
        int sleep = randomSleepMillis();
        return " [service4 sleep " + sleep + " ms]";
    }

    private static int randomSleepMillis() {
        try {
            int timeout = new Random().nextInt(100);
            TimeUnit.MILLISECONDS.sleep(timeout);
            return timeout;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

}