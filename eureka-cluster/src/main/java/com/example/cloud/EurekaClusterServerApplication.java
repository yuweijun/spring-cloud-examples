package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author yuweijun 2017-11-16
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaClusterServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClusterServerApplication.class, args);
    }

}
