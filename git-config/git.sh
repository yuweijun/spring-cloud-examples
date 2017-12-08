#! /bin/bash

dir=$(dirname "$0")
cd ${dir}

rm -rf config*
git init --bare config.git
git clone config.git config
cd config
mkdir properties
cd properties
echo 'key=test config in master' > service-config-application-test.properties
echo 'key=develop config in master' > service-config-application-dev.properties
echo 'key=production config in master' > service-config-application-prod.properties
git add -A :/
git commit -am "init properties files"
git push
git checkout -b develop
git push -u origin develop
echo 'key=test config in develop' > service-config-application-test.properties
echo 'key=develop config in develop' > service-config-application-dev.properties
echo 'key=production config in develop' > service-config-application-prod.properties
git commit -am "update develop branch"
git push
git checkout -b production
git push -u origin production
git push
git pull
echo 'key=test config in production' > service-config-application-test.properties
echo 'key=develop config in production' > service-config-application-dev.properties
echo 'key=production config in production' > service-config-application-prod.properties
git commit -am "update production branch"
git push

