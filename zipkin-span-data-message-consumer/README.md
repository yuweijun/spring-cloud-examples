# Span Data as Messages

You can accumulate and send span data over Spring Cloud Stream by including the spring-cloud-sleuth-stream jar as a dependency, and adding a Channel Binder implementation (e.g. spring-cloud-starter-stream-rabbit for RabbitMQ or spring-cloud-starter-stream-kafka for Kafka). This will automatically turn your app into a producer of messages with payload type Spans.

## Zipkin Consumer

There is a special convenience annotation for setting up a message consumer for the Span data and pushing it into a Zipkin SpanStore. This application

    @SpringBootApplication
    @EnableZipkinStreamServer
    public class Consumer {
        public static void main(String[] args) {
            SpringApplication.run(Consumer.class, args);
        }
    }
    
will listen for the Span data on whatever transport you provide via a Spring Cloud Stream Binder (e.g. include spring-cloud-starter-stream-rabbit for RabbitMQ, and similar starters exist for Redis and Kafka). If you add the following UI dependency

    <groupId>io.zipkin.java</groupId>
    <artifactId>zipkin-autoconfigure-ui</artifactId>
    
Then you’ll have your app a Zipkin server, which hosts the UI and api on port 9411.

The default SpanStore is in-memory (good for demos and getting started quickly). For a more robust solution you can add MySQL and spring-boot-starter-jdbc to your classpath and enable the JDBC SpanStore via configuration, e.g.:

    spring:
      rabbitmq:
        host: ${RABBIT_HOST:localhost}
      datasource:
        schema: classpath:/mysql.sql
        url: jdbc:mysql://${MYSQL_HOST:localhost}/test
        username: root
        password: root
    # Switch this on to create the schema on startup:
        initialize: true
        continueOnError: true
      sleuth:
        enabled: false
    zipkin:
      storage:
        type: mysql
        
## NOTE

The @EnableZipkinStreamServer is also annotated with @EnableZipkinServer so the process will also expose the standard Zipkin server endpoints for collecting spans over HTTP, and for querying in the Zipkin Web UI.

### Custom Consumer

A custom consumer can also easily be implemented using spring-cloud-sleuth-stream and binding to the SleuthSink. Example:

    @EnableBinding(SleuthSink.class)
    @SpringBootApplication(exclude = SleuthStreamAutoConfiguration.class)
    @MessageEndpoint
    public class Consumer {

        @ServiceActivator(inputChannel = SleuthSink.INPUT)
        public void sink(Spans input) throws Exception {
            // ... process spans
        }
    }    