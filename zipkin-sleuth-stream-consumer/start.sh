#!/usr/bin/env bash

dir=$(dirname "$0")
cd ${dir}
cd ..

mvn clean spring-boot:run -f zipkin-sleuth-stream-consumer -Drun.jvmArguments="-Dspring.profiles.active=service1" > logs/zipkin-sleuth-stream-consumer.9851.log 2>&1 &
mvn clean spring-boot:run -f zipkin-sleuth-stream-consumer -Drun.jvmArguments="-Dspring.profiles.active=service2" > logs/zipkin-sleuth-stream-consumer.9852.log 2>&1 &
mvn clean spring-boot:run -f zipkin-sleuth-stream-consumer -Drun.jvmArguments="-Dspring.profiles.active=service3" > logs/zipkin-sleuth-stream-consumer.9853.log 2>&1 &
mvn clean spring-boot:run -f zipkin-sleuth-stream-consumer -Drun.jvmArguments="-Dspring.profiles.active=service4" > logs/zipkin-sleuth-stream-consumer.9854.log 2>&1 &
