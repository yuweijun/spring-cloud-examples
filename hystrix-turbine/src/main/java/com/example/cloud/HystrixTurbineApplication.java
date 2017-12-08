package com.example.cloud;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuweijun 2017-11-28.
 */
@EnableTurbine
@EnableDiscoveryClient
@SpringCloudApplication
public class HystrixTurbineApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixTurbineApplication.class).run(args);
    }

}
