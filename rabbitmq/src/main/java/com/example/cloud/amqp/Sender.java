package com.example.cloud.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author yuweijun 2017-11-20.
 */
@Component
public class Sender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String hello = "hello " + new Date();
        LOGGER.info("Sender : {}", hello);
        this.rabbitTemplate.convertAndSend("hello", hello);
    }

}