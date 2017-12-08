package com.example.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import zipkin.server.EnableZipkinServer;

/**
 * @author yuweijun 2017-11-24.
 */
@SpringBootApplication
@EnableZipkinServer
public class ZipkinJdbcServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZipkinJdbcServerApplication.class).run(args);
    }

}
