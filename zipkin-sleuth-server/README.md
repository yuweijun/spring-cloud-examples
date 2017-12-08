## IMPORTANT

If using Zipkin or Stream, configure the percentage of spans exported using `spring.sleuth.sampler.percentage` (default 0.1, i.e. 10%). 
Otherwise you might think that Sleuth is not working cause it’s omitting some spans.

## NOTE

the SLF4J MDC is always set and logback users will immediately see the trace and span ids in logs per the example above. 
Other logging systems have to configure their own formatter to get the same result. 
The default is logging.pattern.level set to 

    %clr(%5p) %clr([${spring.application.name:},%X{X-B3-TraceId:-},%X{X-B3-SpanId:-},%X{X-Span-Export:-}]){yellow} 

(this is a Spring Boot feature for logback users). 
This means that if you’re not using SLF4J this pattern WILL NOT be automatically applied.

## start server

    mvn springboot-run:boot

## 参考

1. http://cloud.spring.io/spring-cloud-sleuth/1.0.x/