## 准备 

1. 启动注册中心eureka项目 
2. 启动配置中心git-config项目 

## 创建bootstrap.properties配置来指定config server

    server.port=7002
    spring.application.name=service-config-application
    spring.cloud.config.profile=dev
    spring.cloud.config.label=master
    spring.cloud.config.uri=http://localhost:7001/
    
spring.application.name：对应前配置文件中的{application}部分
spring.cloud.config.profile：对应前配置文件中的{profile}部分
spring.cloud.config.label：对应前配置文件的git分支
spring.cloud.config.uri：配置中心的地址

这里需要格外注意：上面这些属性必须配置在bootstrap.properties中，config部分内容才能被正确加载。
因为config的相关配置会先于application.properties，而bootstrap.properties的加载也是先于application.properties。

如果这些配置写在application.properties文件中时，应用启动时会加载不到配置文件中的key而抛出异常：

> Caused by: java.lang.IllegalArgumentException: Could not resolve placeholder 'key' in value "${key}"

如果git-config-server注册为服务，则配置如下：

    eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
    spring.cloud.config.discovery.enabled=true
    spring.cloud.config.discovery.serviceId=git-config-server
    spring.cloud.config.label=master
    spring.cloud.config.profile=dev

## 服务启动之后访问

> http://localhost:7002/value?name=key

这里的key就是在配置中心里对应的properties文件中的键名。