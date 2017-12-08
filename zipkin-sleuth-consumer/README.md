##  add default sampler bean

    @Bean
    public Sampler defaultSampler() {
        return new AlwaysSampler();
    }    

## start zipkin server
    
    mvn spring-boot:run -f zipkin-sleuth-server
    
## start service1..service4

    mvn clean spring-boot:run -f zipkin-sleuth-consumer -Drun.jvmArguments="-Dspring.profiles.active=service1"
    mvn clean spring-boot:run -f zipkin-sleuth-consumer -Drun.jvmArguments="-Dspring.profiles.active=service2"
    mvn clean spring-boot:run -f zipkin-sleuth-consumer -Drun.jvmArguments="-Dspring.profiles.active=service3"
    mvn clean spring-boot:run -f zipkin-sleuth-consumer -Drun.jvmArguments="-Dspring.profiles.active=service4"
    
## request pages

    http://localhost:9871/service1
    http://localhost:9871/service2
    http://localhost:9871/service3
    http://localhost:9871/service4
    
## request logs
    
### [zipkin-sleuth-service1,db77950723f18017,21c122a4dd41b5a6,true] 说明 
    
    1. zipkin-sleuth-service1: zipkin service name
    2. db77950723f18017: trace id
    3. 21c122a4dd41b5a6: span id，如果是请求发起的节点，这个与trace id一样
    4. true or false: 此请求是否写入zipkin
    
### 4个服务的日志如下    

    2017-11-24 12:56:16.776  INFO [zipkin-sleuth-service1,db77950723f18017,db77950723f18017,true] 12891 --- [nio-9871-exec-3] com.example.cloud.HomeController         : service1
    2017-11-24 12:56:16.841  INFO [zipkin-sleuth-service1,bd686b74bb369c6b,bd686b74bb369c6b,false] 12891 --- [nio-9871-exec-1] com.example.cloud.HomeController         : service1
    2017-11-24 12:56:17.025  INFO [zipkin-sleuth-service1,686deb98b5e97861,686deb98b5e97861,true] 12891 --- [nio-9871-exec-5] com.example.cloud.HomeController         : service1
    2017-11-24 12:56:17.201  INFO [zipkin-sleuth-service1,e18da96c7d11568e,e18da96c7d11568e,false] 12891 --- [nio-9871-exec-6] com.example.cloud.HomeController         : service1
    2017-11-24 12:56:17.381  INFO [zipkin-sleuth-service1,81833c66f3dbe3e8,81833c66f3dbe3e8,false] 12891 --- [nio-9871-exec-8] com.example.cloud.HomeController         : service1
    2017-11-24 12:56:17.710  INFO [zipkin-sleuth-service1,55073a4bc8b3d583,55073a4bc8b3d583,true] 12891 --- [nio-9871-exec-9] com.example.cloud.HomeController         : service1
    2017-11-24 12:56:17.776  INFO [zipkin-sleuth-service1,4794768e6fadc9e0,4794768e6fadc9e0,false] 12891 --- [nio-9871-exec-2] com.example.cloud.HomeController         : service1
    2017-11-24 12:56:48.492  INFO [zipkin-sleuth-service1,7f79657707da4e23,7f79657707da4e23,false] 12891 --- [nio-9871-exec-4] com.example.cloud.HomeController         : service1

    ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
    2017-11-24 12:56:16.417  INFO [zipkin-sleuth-service2,318d3809f5eb8059,e5c82bd5d3b09eaa,true] 13075 --- [nio-9872-exec-2] com.example.cloud.HomeController         : service2
    2017-11-24 12:56:16.813  INFO [zipkin-sleuth-service2,db77950723f18017,21c122a4dd41b5a6,true] 13075 --- [nio-9872-exec-4] com.example.cloud.HomeController         : service2
    2017-11-24 12:56:16.889  INFO [zipkin-sleuth-service2,bd686b74bb369c6b,5137ab642de0bd92,false] 13075 --- [nio-9872-exec-5] com.example.cloud.HomeController         : service2
    2017-11-24 12:56:17.079  INFO [zipkin-sleuth-service2,686deb98b5e97861,05b22abea79c8f42,true] 13075 --- [nio-9872-exec-6] com.example.cloud.HomeController         : service2
    2017-11-24 12:56:17.264  INFO [zipkin-sleuth-service2,e18da96c7d11568e,809d7bbe74fec57c,false] 13075 --- [nio-9872-exec-7] com.example.cloud.HomeController         : service2
    2017-11-24 12:56:17.443  INFO [zipkin-sleuth-service2,81833c66f3dbe3e8,0f690abc545273cf,false] 13075 --- [nio-9872-exec-8] com.example.cloud.HomeController         : service2
    2017-11-24 12:56:17.749  INFO [zipkin-sleuth-service2,55073a4bc8b3d583,250ea8860b567a60,true] 13075 --- [nio-9872-exec-9] com.example.cloud.HomeController         : service2
    2017-11-24 12:56:17.809  INFO [zipkin-sleuth-service2,4794768e6fadc9e0,825915a924020ba1,false] 13075 --- [nio-9872-exec-1] com.example.cloud.HomeController         : service2
    2017-11-24 12:56:48.544  INFO [zipkin-sleuth-service2,7f79657707da4e23,55c68858873b5fab,false] 13075 --- [nio-9872-exec-3] com.example.cloud.HomeController         : service2

    ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
    2017-11-24 12:56:16.387  INFO [zipkin-sleuth-service3,f1c7f407f5d3102d,cd3383fecd85e24c,false] 13193 --- [nio-9873-exec-9] com.example.cloud.HomeController         : service3
    2017-11-24 12:56:16.428  INFO [zipkin-sleuth-service3,318d3809f5eb8059,bf3ac6fb29705a5c,true] 13193 --- [io-9873-exec-10] com.example.cloud.HomeController         : service3
    2017-11-24 12:56:16.866  INFO [zipkin-sleuth-service3,db77950723f18017,b06cab867cee870b,true] 13193 --- [nio-9873-exec-2] com.example.cloud.HomeController         : service3
    2017-11-24 12:56:16.992  INFO [zipkin-sleuth-service3,bd686b74bb369c6b,f25fe7daf9ca9d81,false] 13193 --- [nio-9873-exec-1] com.example.cloud.HomeController         : service3
    2017-11-24 12:56:17.114  INFO [zipkin-sleuth-service3,686deb98b5e97861,e1aab2a988576e56,true] 13193 --- [nio-9873-exec-3] com.example.cloud.HomeController         : service3
    2017-11-24 12:56:17.296  INFO [zipkin-sleuth-service3,e18da96c7d11568e,f47f0e8c6fa7745a,false] 13193 --- [nio-9873-exec-4] com.example.cloud.HomeController         : service3
    2017-11-24 12:56:17.461  INFO [zipkin-sleuth-service3,81833c66f3dbe3e8,11643b7d44f19176,false] 13193 --- [nio-9873-exec-6] com.example.cloud.HomeController         : service3
    2017-11-24 12:56:17.781  INFO [zipkin-sleuth-service3,55073a4bc8b3d583,6340f25c55df811e,true] 13193 --- [nio-9873-exec-5] com.example.cloud.HomeController         : service3
    2017-11-24 12:56:17.863  INFO [zipkin-sleuth-service3,4794768e6fadc9e0,a44d01cc052f19ef,false] 13193 --- [nio-9873-exec-8] com.example.cloud.HomeController         : service3
    2017-11-24 12:56:48.559  INFO [zipkin-sleuth-service3,7f79657707da4e23,7b9728e5edc27468,false] 13193 --- [nio-9873-exec-9] com.example.cloud.HomeController         : service3

    ──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
    2017-11-24 12:56:16.456  INFO [zipkin-sleuth-service4,f1c7f407f5d3102d,f81c7967819b0f17,false] 13217 --- [nio-9874-exec-9] com.example.cloud.HomeController         : service4
    2017-11-24 12:56:16.470  INFO [zipkin-sleuth-service4,318d3809f5eb8059,094377e269a03154,true] 13217 --- [io-9874-exec-10] com.example.cloud.HomeController         : service4
    2017-11-24 12:56:16.913  INFO [zipkin-sleuth-service4,db77950723f18017,9c303170a2482795,true] 13217 --- [nio-9874-exec-2] com.example.cloud.HomeController         : service4
    2017-11-24 12:56:17.033  INFO [zipkin-sleuth-service4,bd686b74bb369c6b,f183045e218ab567,false] 13217 --- [nio-9874-exec-1] com.example.cloud.HomeController         : service4
    2017-11-24 12:56:17.142  INFO [zipkin-sleuth-service4,686deb98b5e97861,0d3f2df0a61e801a,true] 13217 --- [nio-9874-exec-3] com.example.cloud.HomeController         : service4
    2017-11-24 12:56:17.348  INFO [zipkin-sleuth-service4,e18da96c7d11568e,e61ad10b204fd71c,false] 13217 --- [nio-9874-exec-4] com.example.cloud.HomeController         : service4
    2017-11-24 12:56:17.479  INFO [zipkin-sleuth-service4,81833c66f3dbe3e8,c5dfb09d76489f78,false] 13217 --- [nio-9874-exec-5] com.example.cloud.HomeController         : service4
    2017-11-24 12:56:17.840  INFO [zipkin-sleuth-service4,55073a4bc8b3d583,478c51c0f27e9e8c,true] 13217 --- [nio-9874-exec-6] com.example.cloud.HomeController         : service4
    2017-11-24 12:56:17.921  INFO [zipkin-sleuth-service4,4794768e6fadc9e0,6f4c128967f7606b,false] 13217 --- [nio-9874-exec-7] com.example.cloud.HomeController         : service4
    2017-11-24 12:56:48.579  INFO [zipkin-sleuth-service4,7f79657707da4e23,26085db8769d9094,false] 13217 --- [nio-9874-exec-9] com.example.cloud.HomeController         : service4
    
    