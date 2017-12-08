package com.example.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuweijun 2017-11-13
 */
@RefreshScope
@RestController
public class ConfigValueController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigValueController.class);

    @Value("${key}")
    private String key;

    @RequestMapping("/value")
    public String value(String name) {
        LOGGER.info("request from client for key : {}", name);
        if ("key".equals(name)) {
            return key;
        } else {
            return name;
        }
    }

}
