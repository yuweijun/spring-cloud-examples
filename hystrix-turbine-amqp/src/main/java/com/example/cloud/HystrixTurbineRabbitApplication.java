package com.example.cloud;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * @author yuweijun 2017-11-28.
 */
@EnableTurbineStream
@EnableDiscoveryClient
@SpringCloudApplication
public class HystrixTurbineRabbitApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixTurbineRabbitApplication.class).run(args);
    }

}
