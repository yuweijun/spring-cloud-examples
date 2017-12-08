package com.example.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 * @author yuweijun 2017-11-24.
 */
@SpringBootApplication
@EnableZipkinStreamServer
public class ZipkinSleuthStreamServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZipkinSleuthStreamServerApplication.class).run(args);
    }

}
