package com.example.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author yuweijun 2017-11-14.
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class GitConfigApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(GitConfigApplication.class).web(true).run(args);
    }
    
}
