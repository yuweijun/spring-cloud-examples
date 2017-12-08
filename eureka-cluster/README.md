## hosts 修改

在/etc/hosts文件中添加对peer1和peer2的转换

    127.0.0.1 peer1
    127.0.0.1 peer2

## start server

    $ mvn spring-boot:run -f eureka-cluster/pom.xml -Drun.jvmArguments="-Dserver.port=1111 -Dspring.profiles.active=peer1"
    $ mvn spring-boot:run -f eureka-cluster/pom.xml -Drun.jvmArguments="-Dserver.port=1112 -Dspring.profiles.active=peer2"
    
先启动的那个会抛出如下错误：
    
    ERROR 27876 --- [nfoReplicator-0] c.n.d.s.t.d.RedirectingEurekaHttpClient  : Request execution error
    com.sun.jersey.api.client.ClientHandlerException: java.net.ConnectException: Connection refused (Connection refused)
            at com.sun.jersey.client.apache4.ApacheHttpClient4Handler.handle(ApacheHttpClient4Handler.java:187) ~[jersey-apache-client4-1.19.1.jar:1.19.1]
            at com.sun.jersey.api.client.filter.GZIPContentEncodingFilter.handle(GZIPContentEncodingFilter.java:123) ~[jersey-client-1.19.1.jar:1.19.1]
            at com.netflix.discovery.EurekaIdentityHeaderFilter.handle(EurekaIdentityHeaderFilter.java:27) ~[eureka-client-1.4.12.jar:1.4.12]
            at com.sun.jersey.api.client.Client.handle(Client.java:652) ~[jersey-client-1.19.1.jar:1.19.1]
            at com.sun.jersey.api.client.WebResource.handle(WebResource.java:682) ~[jersey-client-1.19.1.jar:1.19.1]
            at com.sun.jersey.api.client.WebResource.access$200(WebResource.java:74) ~[jersey-client-1.19.1.jar:1.19.1]
            at com.sun.jersey.api.client.WebResource$Builder.post(WebResource.java:570) ~[jersey-client-1.19.1.jar:1.19.1]
            at com.netflix.discovery.shared.transport.jersey.AbstractJerseyEurekaHttpClient.register(AbstractJerseyEurekaHttpClient.java:56) ~[eureka-client-1.4.12.jar:1.4.12]
            at com.netflix.discovery.shared.transport.decorator.EurekaHttpClientDecorator$1.execute(EurekaHttpClientDecorator.java:59) [eureka-client-1.4.12.jar:1.4.12]
            at com.netflix.discovery.shared.transport.decorator.MetricsCollectingEurekaHttpClient.execute(MetricsCollectingEurekaHttpClient.java:73) ~[eureka-client-1.4.12.jar:1.4.12]
            at com.netflix.discovery.shared.transport.decorator.EurekaHttpClientDecorator.register(EurekaHttpClientDecorator.java:56) [eureka-client-1.4.12.jar:1.4.12]
            at com.netflix.discovery.shared.transport.decorator.EurekaHttpClientDecorator$1.execute(EurekaHttpClientDecorator.java:59) [eureka-client-1.4.12.jar:1.4.12]
            at com.netflix.discovery.shared.transport.decorator.RedirectingEurekaHttpClient.executeOnNewServer(RedirectingEurekaHttpClient.java:118) ~[eureka-client-1.4.12.jar:1.4.12]
            at com.netflix.discovery.shared.transport.decorator.RedirectingEurekaHttpClient.execute(RedirectingEurekaHttpClient.java:79) ~[eureka-client-1.4.12.jar:1.4.12]
            at com.netflix.discovery.shared.transport.decorator.EurekaHttpClientDecorator.register(EurekaHttpClientDecorator.java:56) [eureka-client-1.4.12.jar:1.4.12]
            at com.netflix.discovery.shared.transport.decorator.EurekaHttpClientDecorator$1.execute(EurekaHttpClientDecorator.java:59) [eureka-client-1.4.12.jar:1.4.12]
            at com.netflix.discovery.shared.transport.decorator.RetryableEurekaHttpClient.execute(RetryableEurekaHttpClient.java:119) [eureka-client-1.4.12.jar:1.4.12]
            at com.netflix.discovery.shared.transport.decorator.EurekaHttpClientDecorator.register(EurekaHttpClientDecorator.java:56) [eureka-client-1.4.12.jar:1.4.12]
            at com.netflix.discovery.shared.transport.decorator.EurekaHttpClientDecorator$1.execute(EurekaHttpClientDecorator.java:59) [eureka-client-1.4.12.jar:1.4.12]
            at com.netflix.discovery.shared.transport.decorator.SessionedEurekaHttpClient.execute(SessionedEurekaHttpClient.java:77) [eureka-client-1.4.12.jar:1.4.12]
            at com.netflix.discovery.shared.transport.decorator.EurekaHttpClientDecorator.register(EurekaHttpClientDecorator.java:56) [eureka-client-1.4.12.jar:1.4.12]
            at com.netflix.discovery.DiscoveryClient.register(DiscoveryClient.java:815) [eureka-client-1.4.12.jar:1.4.12]
            at com.netflix.discovery.InstanceInfoReplicator.run(InstanceInfoReplicator.java:104) [eureka-client-1.4.12.jar:1.4.12]
            at com.netflix.discovery.InstanceInfoReplicator$1.run(InstanceInfoReplicator.java:88) [eureka-client-1.4.12.jar:1.4.12]
            at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511) [na:1.8.0_151]
            at java.util.concurrent.FutureTask.run(FutureTask.java:266) [na:1.8.0_151]
            at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511) [na:1.8.0_151]
            at java.util.concurrent.FutureTask.run(FutureTask.java:266) [na:1.8.0_151]
            at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.access$201(ScheduledThreadPoolExecutor.java:180) [na:1.8.0_151]
            at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:293) [na:1.8.0_151]
            at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149) [na:1.8.0_151]
            at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624) [na:1.8.0_151]
            at java.lang.Thread.run(Thread.java:748) [na:1.8.0_151]
    Caused by: java.net.ConnectException: Connection refused (Connection refused)
