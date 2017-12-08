## 准备 

1. 启动注册中心eureka项目 
2. 启动配置中心git-config项目
3. 启动rabbit-server

## 设置配置文件

在项目根目录下运行以下脚本，配置中心的配置文件格式与当前项目名是有关系的，配置文件形式如： {application-name}-{profile}.yml

    cd git-config/config/properties
    echo 'key=test config in bus rabbitmq master' > bus-rabbitmq-config-application.properties
    echo 'key=develop config in bus rabbitmq master' > bus-rabbitmq-config-application-dev.properties
    echo 'key=production config in bus rabbitmq master' > bus-rabbitmq-config-application-prod.properties

## 启动

    $ mvn spring-boot:run -f bus-rabbitmq-config/pom.xml -Drun.jvmArguments="-Dserver.port=7007" > logs/bus-rabbitmq-config.7007.log &
    $ mvn spring-boot:run -f bus-rabbitmq-config/pom.xml -Drun.jvmArguments="-Dserver.port=7008" > logs/bus-rabbitmq-config.7008.log &
    $ mvn spring-boot:run -f bus-rabbitmq-config/pom.xml -Drun.jvmArguments="-Dserver.port=7009" > logs/bus-rabbitmq-config.7009.log &
    
在启动时候，客户端程序多了一个/bus/refresh请求。    

## 服务启动之后访问

> http://localhost:7007/value?name=key
> http://localhost:7008/value?name=key
> http://localhost:7009/value?name=key

## 修改配置文件 

1. 修改config-repo/bus-rabbitmq-config-application-dev.properties中的key属性值
2. 并发送POST请求到其中的一个/bus/refresh到7007端口的服务：curl -X POST 'http://localhost:7007/bus/refresh'
3. 然后访问另外2个端口的服务，配置都会同步更新。
