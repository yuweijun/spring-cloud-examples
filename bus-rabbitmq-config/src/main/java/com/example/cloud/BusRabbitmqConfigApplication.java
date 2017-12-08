package com.example.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by yuweijun on 2017-11-20
 */
@SpringBootApplication
@EnableEurekaClient
public class BusRabbitmqConfigApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(BusRabbitmqConfigApplication.class).run(args);
    }

}
