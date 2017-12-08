package com.example.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author yuweijun 2017-11-23.
 */
@SpringBootApplication
public class ZipkinSleuthStreamConsumerApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * http://cloud.spring.io/spring-cloud-sleuth/1.0.x/
     * Sampling
     * In distributed tracing the data volumes can be very high so sampling can be important
     * (you usually don’t need to export all spans to get a good picture of what is happening).
     * Spring Cloud Sleuth has a Sampler strategy that you can implement to take control of the sampling algorithm.
     * Samplers do not stop span (correlation) ids from being generated, but they do prevent the tags and
     * events being attached and exported. By default you get a strategy that continues to trace
     * if a span is already active, but new ones are always marked as non-exportable.
     * If all your apps run with this sampler you will see traces in logs, but not in any remote store.
     * For testing the default is often enough, and it probably is all you need
     * if you are only using the logs (e.g. with an ELK aggregator).
     * If you are exporting span data to Zipkin or Spring Cloud Stream,
     * there is also an AlwaysSampler that exports everything and a PercentageBasedSampler
     * that samples a fixed fraction of spans.
     * <p>
     * NOTE
     * the PercentageBasedSampler is the default if you are using spring-cloud-sleuth-zipkin or spring-cloud-sleuth-stream.
     * You can configure the exports using spring.sleuth.sampler.percentage.
     * The passed value needs to be a double from 0.0 to 1.0 so it’s not a percentage.
     * For backwards compatibility reasons we’re not changing the property name.
     * A sampler can be installed just by creating a bean definition, e.g:
     */
    @Bean
    public Sampler defaultSampler() {
        // for development environment
        return new AlwaysSampler();
    }

    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(ZipkinSleuthStreamConsumerApplication.class).run(args);
    }

}
