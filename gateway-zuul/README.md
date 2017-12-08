## 准备 

1. 启动注册中心eureka项目 
2. 启动配置中心git-config项目 
3. 启动service项目
4. 启动service-config项目
5. 启动circuit-breaker-consumer项目，测试熔断功能
 
## 启动应用 

访问：

> http://localhost:5555/service/echo?message=yu
> http://localhost:5555/service/echo?message=yu&test=1
> http://localhost:5555/service/rand
> http://localhost:5555/service-config/value?name=key
> http://localhost:5555/service-config/value?name=key&test=1
> http://localhost:5555/circuit-breaker-consumer/rand

上面这个请求`http://localhost:5555/service/rand`因为没有提供熔断，可能会抛异常。

## 网关的重要性

最后，总结一下为什么服务网关是微服务架构的重要部分，是我们必须要去做的原因：

1. 不仅仅实现了路由功能来屏蔽诸多服务细节，更实现了服务级别、均衡负载的路由。
2. 实现了接口权限校验与微服务业务逻辑的解耦。通过服务网关中的过滤器，在各生命周期中去校验请求的内容，
   将原本在对外服务层做的校验前移，保证了微服务的无状态性，同时降低了微服务的测试难度，让服务本身更集中关注业务逻辑的处理。
3. 实现了断路器，不会因为具体微服务的故障而导致服务网关的阻塞，依然可以对外服务。

参考：

1. http://blog.didispace.com/springcloud5/
2. https://github.com/spring-cloud-samples/sample-zuul-filters
