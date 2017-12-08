package com.example.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author yuweijun 2017-11-13
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignConsumerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(FeignConsumerApplication.class).run(args);
    }

}
