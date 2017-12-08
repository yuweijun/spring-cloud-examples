#!/usr/bin/env bash

dir=$(dirname "$0")
cd ${dir}
cd ..

mvn clean spring-boot:run -f zipkin-sleuth-consumer -Drun.jvmArguments="-Dspring.profiles.active=service1" > logs/zipkin-sleuth-consumer.9871.log 2>&1 &
mvn clean spring-boot:run -f zipkin-sleuth-consumer -Drun.jvmArguments="-Dspring.profiles.active=service2" > logs/zipkin-sleuth-consumer.9872.log 2>&1 &
mvn clean spring-boot:run -f zipkin-sleuth-consumer -Drun.jvmArguments="-Dspring.profiles.active=service3" > logs/zipkin-sleuth-consumer.9873.log 2>&1 &
mvn clean spring-boot:run -f zipkin-sleuth-consumer -Drun.jvmArguments="-Dspring.profiles.active=service4" > logs/zipkin-sleuth-consumer.9874.log 2>&1 &
