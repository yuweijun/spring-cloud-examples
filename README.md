## spring cloud

    RELEASE             DOCUMENTATION
    Finchley M4         Reference
    Edgware RC1         Reference
    Dalston SR4         Reference
    Camden SR7          Reference
    Brixton SR7         Reference
    Angel SR6           Reference

[https://projects.spring.io/spring-cloud/](https://projects.spring.io/spring-cloud/)

## start eureka

在默认设置下，Eureka服务注册中心也会将自己作为客户端来尝试注册它自己，所以我们需要禁用它的客户端注册行为。禁止方式如下：

    eureka.client.register-with-eureka=false
    eureka.client.fetch-registry=false
    
如果不禁止的话，会得到如下错误：

> com.sun.jersey.api.client.ClientHandlerException: java.net.ConnectException: Connection refused: connect
> c.n.d.s.t.d.RetryableEurekaHttpClient    : Request execution failure
> com.netflix.discovery.DiscoveryClient    : DiscoveryClient_UNKNOWN/DESKTOP-MQ8D0C9:8761 - was unable to refresh its cache! status = Cannot execute request on any known server

应该是因为当注册中心将自己作为客户端注册的时候，发现在server上的端口被自己占据了，然后就挂了。

启动服务注册中心的时候虽然启动没问题，但是访问http://localhost:8761/的时候就访问不了，但是如果指定端口server.port=1111，就一切正常了。

用以下命令方式运行一次之后，就可以使用8761端口进行访问了，目前还不知道原因。

    $ mvn spring-boot:run -f eureka/pom.xml -Drun.jvmArguments="-Dserver.port=8761"
    
## start service

    $ mvn spring-boot:run -f service/pom.xml -Drun.jvmArguments="-Dserver.port=8081"
    $ mvn spring-boot:run -f service/pom.xml -Drun.jvmArguments="-Dserver.port=8082"
    
## start consumer

    $ mvn spring-boot:run -f service/pom.xml -Drun.jvmArguments="-Dserver.port=8091"
    $ mvn spring-boot:run -f service/pom.xml -Drun.jvmArguments="-Dserver.port=8092"
    
## start feign consumer

    $ mvn spring-boot:run -f feign-consumer/pom.xml -Drun.jvmArguments="-Dserver.port=8095"
    
## 启动所有应用 

运行项目根目录下这个脚本：

    $ ./start.sh    
    
