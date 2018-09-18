#! /bin/bash

dir=$(dirname "$0")
cd ${dir}

if [ -d logs ]
then
    echo "start run applications"
else
    mkdir logs
fi

# eureka server and config server run firstly
echo "eureka server start"
mvn spring-boot:run -f eureka -Drun.jvmArguments="-Dserver.port=8761" > logs/eureka.8761.log &

sleep 10
echo "config server start"
mvn spring-boot:run -f git-config -Drun.jvmArguments="-Dserver.port=7001" > logs/git-config.7001.log &

sleep 10
echo "service server start"
mvn spring-boot:run -f service -Drun.jvmArguments="-Dserver.port=8081" > logs/service.8081.log &
mvn spring-boot:run -f service -Drun.jvmArguments="-Dserver.port=8082" > logs/service.8082.log &

sleep 10
echo "consumer server start"
mvn spring-boot:run -f consumer -Drun.jvmArguments="-Dserver.port=8091" > logs/consumer.8091.log &

sleep 10
echo "feign-consumer server start"
mvn spring-boot:run -f feign-consumer -Drun.jvmArguments="-Dserver.port=8095" > logs/feign-consumer.8095.log &

sleep 10
echo "circuit-breaker-consumer server start"
mvn spring-boot:run -f circuit-breaker-consumer -Drun.jvmArguments="-Dserver.port=8098" > logs/circuit-breaker-consumer.8098.log &

sleep 10
echo "gateway-zuul server start"
mvn spring-boot:run -f gateway-zuul -Drun.jvmArguments="-Dserver.port=5555" > logs/gateway-zuul.5555.log &

sleep 10
echo "service-config server start"
mvn spring-boot:run -f service-config -Drun.jvmArguments="-Dserver.port=7002" > logs/service-config.7002.log &

sleep 10
echo "hystrix-dashboard server start"
mvn spring-boot:run -f hystrix-dashboard -Drun.jvmArguments="-Dserver.port=7788" > logs/hystrix-dashboard.7788.log &

sleep 10
echo "hystrix-turbine server start"
mvn spring-boot:run -f hystrix-turbine -Drun.jvmArguments="-Dserver.port=7799" > logs/hystrix-turbine.7799.log &

echo "finished....."

echo "firefox http://localhost:7788/hystrix"
echo "input http://localhost:8098/hystrix.stream"
echo "curl http://localhost:8098/rand"
echo "http://localhost:7788/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8098%2Fhystrix.stream"
echo "http://localhost:7788/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A7799%2Fturbine.stream"
