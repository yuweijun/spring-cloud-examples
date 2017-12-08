#!/usr/bin/env bash

dir=$(dirname "$0")
cd ${dir}
echo ${dir}

mvn spring-boot:run