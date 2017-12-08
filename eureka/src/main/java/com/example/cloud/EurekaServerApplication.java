package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Distributed/versioned configuration
 * Service registration and discovery
 * Routing
 * Service-to-service calls
 * Load balancing
 * Circuit Breakers
 * Global locks
 * Leadership election and cluster state
 * Distributed messaging
 * <p>
 * https://github.com/spring-cloud-samples/eureka/blob/master/src/main/java/eurekademo/EurekaApplication.java
 * <p>
 * Created by yuweijun on 2017-11-13.
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}
