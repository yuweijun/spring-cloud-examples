## create git repository

运行当前项目下的`git.sh`脚本，生成git仓库，并切出了一个工作空间config目录，并将目录地址更新到`application.properties`上：

> spring.cloud.config.server.git.uri=/github.com/learning-programming/spring-cloud/git-config/config

## url

URL与配置文件的映射关系如下：

    /{application}/{profile}[/{label}]
    /{application}-{profile}.yml
    /{label}/{application}-{profile}.yml
    /{application}-{profile}.properties
    /{label}/{application}-{profile}.properties

上面的url会映射{application}-{profile}.properties对应的配置文件，{label}对应git上不同的分支，默认为master。