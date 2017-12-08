## 启动相关服务

运行项目根目录下面的 start.sh 脚本，主要是为了启动circuit-breaker-consumer应用。

## start server

    运行主类：HystrixDashboardApplication

## get url

    http://localhost:7788/hystrix
    
在 Hystrix Dashboard 中输入以下链接：

    http://localhost:8098/hystrix.stream
    
### 手动多次刷新下面的链接

    http://localhost:8098/rand    
 
并查看Dashboard的图表数字变化

    http://localhost:7788/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8098%2Fhystrix.stream    
    