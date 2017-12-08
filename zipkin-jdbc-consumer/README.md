## download zipkin.jar

    http://search.maven.org/remote_content?g=io.zipkin.java&a=zipkin-server&v=LATEST&c=exec
    
## start zipkin server

    java -jar zipkin.jar
    
    或者是启动项目里的zipkin-jdbc-server，需要本地同时安装有mysql。
    
## start service1..service4

    mvn clean spring-boot:run -f zipkin-jdbc-consumer -Drun.jvmArguments="-Dspring.profiles.active=service1"
    mvn clean spring-boot:run -f zipkin-jdbc-consumer -Drun.jvmArguments="-Dspring.profiles.active=service2"
    mvn clean spring-boot:run -f zipkin-jdbc-consumer -Drun.jvmArguments="-Dspring.profiles.active=service3"
    mvn clean spring-boot:run -f zipkin-jdbc-consumer -Drun.jvmArguments="-Dspring.profiles.active=service4"
    
## request pages

    http://localhost:9091/service1
    http://localhost:9091/service2
    http://localhost:9091/service3
    http://localhost:9091/service4
    