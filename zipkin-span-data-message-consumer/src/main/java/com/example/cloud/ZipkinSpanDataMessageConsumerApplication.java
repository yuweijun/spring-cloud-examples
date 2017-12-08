package com.example.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 * @author yuweijun 2017-11-23.
 */
@SpringBootApplication
@EnableZipkinStreamServer
public class ZipkinSpanDataMessageConsumerApplication {

    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(ZipkinSpanDataMessageConsumerApplication.class).run(args);
    }

}
