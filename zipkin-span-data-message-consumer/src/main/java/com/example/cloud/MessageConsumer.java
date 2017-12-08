package com.example.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.stream.Host;
import org.springframework.cloud.sleuth.stream.SleuthSink;
import org.springframework.cloud.sleuth.stream.SleuthStreamAutoConfiguration;
import org.springframework.cloud.sleuth.stream.Spans;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * @author yuweijun 2017-11-27.
 */
@EnableBinding(SleuthSink.class)
@SpringBootApplication(exclude = SleuthStreamAutoConfiguration.class)
@MessageEndpoint
public class MessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    @ServiceActivator(inputChannel = SleuthSink.INPUT)
    public void sink(Spans input) throws Exception {
        Host host = input.getHost();
        LOGGER.info("host is : {}, {}, {}", host.getAddress(), host.getIpv4(), host.getServiceName());
        LOGGER.info("spans is : {}", input);
    }

}
