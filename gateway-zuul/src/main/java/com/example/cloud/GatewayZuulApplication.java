package com.example.cloud;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author yuweijun 2017-11-15.
 */
@EnableZuulProxy
@SpringCloudApplication
public class GatewayZuulApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(GatewayZuulApplication.class)
                .web(true)
                .properties("server.port=5555", "spring.application.name=gateway-zuul-application")
                .run(args);
    }

}
