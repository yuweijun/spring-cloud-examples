## 项目启动报错

    Parameter 0 of method sleuthStreamSpanReporter in org.springframework.cloud.sleuth.stream.SleuthStreamAutoConfiguration required a bean of type 'org.springframework.cloud.sleuth.stream.HostLocator' that could not be found.
        - Bean method 'zipkinEndpointLocator' not loaded because @ConditionalOnProperty (spring.zipkin.locator.discovery.enabled=true) did not find property 'spring.zipkin.locator.discovery.enabled'
    Action:
    Consider revisiting the conditions above or defining a bean of type 'org.springframework.cloud.sleuth.stream.HostLocator' in your configuration.
    
### 错误处理
    
移除依赖冲突，不是直接使用http方式发送数据给zipkin，而是先将消息发送给rabbitmq，zipkin服务再去rabbitmq去获取数据：
    
    <!--<dependency>-->
       <!--<groupId>org.springframework.cloud</groupId>-->
       <!--<artifactId>spring-cloud-sleuth-zipkin</artifactId>-->
    <!--</dependency>-->
    <!--<dependency>-->
        <!--<groupId>org.springframework.cloud</groupId>-->
        <!--<artifactId>spring-cloud-starter-zipkin</artifactId>-->
    <!--</dependency>-->    

## 度量(metrics)

如果依赖了spring-cloud-sleuth-zipkin，应用将生成并收集Zipkin-compatible traces，一般会通过HTTP将这些traces发送给一个本地Zipkin服务器(port 9411)，使用spring.zipkin.baseUrl来配置服务的地址
如果依赖了spring-cloud-sleuth-stream，应用将通过Spring Cloud Stream生成并收集traces，应用自动成为tracer消息的生产者，这些消息会通过你的中间件分发(e.g. RabbitMQ,Apache Kafka,Redis)

如果使用Zipkin或Stream，使用spring.sleuth.sampler.percentage配置输出spans的百分比(默认10%)，不然你可能会认为Sleuth没有工作，因为他省略了一些spans

SLF4J MDC一直处于工作状态，logback用户可以在logs中立刻看到trace和span id，其他logging系统不得不配置他们自己的模式以得到相同的结果，默认logging.pattern.level设置为%clr(%5p) %clr([${spring.application.name:},%X{X-B3-TraceId:-},%X{X-B3-SpanId:-},%X{X-Span-Export:-}]){yellow}(对于logback用户，这是一种Spring Boot特征)，这意味着如果你没有使用SLF4J这个模式将不会自动适用

## start zipkin server
    
    mvn spring-boot:run -f zipkin-sleuth-stream-server
    
## start service1..service4

    mvn clean spring-boot:run -f zipkin-sleuth-stream-consumer -Drun.jvmArguments="-Dspring.profiles.active=service1"
    mvn clean spring-boot:run -f zipkin-sleuth-stream-consumer -Drun.jvmArguments="-Dspring.profiles.active=service2"
    mvn clean spring-boot:run -f zipkin-sleuth-stream-consumer -Drun.jvmArguments="-Dspring.profiles.active=service3"
    mvn clean spring-boot:run -f zipkin-sleuth-stream-consumer -Drun.jvmArguments="-Dspring.profiles.active=service4"
    
## request pages

    http://localhost:9851/service1
    http://localhost:9851/service2
    http://localhost:9851/service3
    http://localhost:9851/service4
