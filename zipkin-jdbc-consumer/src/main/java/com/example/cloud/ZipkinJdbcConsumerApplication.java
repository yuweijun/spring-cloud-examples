package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yuweijun 2017-11-23.
 */
@SpringBootApplication
public class ZipkinJdbcConsumerApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ZipkinJdbcConsumerApplication.class);
        app.run(args);
    }

}
