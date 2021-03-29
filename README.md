## architect-microservice
《架构探险-轻量级微服务架构》阅读笔记，希望借助于这本书搭建一套轻量级的微服务框架，理解微服务的实现原理。

## 2020-09-28
1. 通过zookeeper实现springboot服务启动注册功能
2. 基于docker启动的zookeeper连接注册失败，最终采用windows环境下的伪集群方式搭建
3. zookeeper集群搭建方式（https://www.jianshu.com/p/3047599c13c7），也可以通过百度网盘下载直接使用（链接：https://pan.baidu.com/s/17sepmZyq6rpvrLQPJVCttA 提取码：6ynt ）解压后放到d盘下根目录下，进入文件夹zookeeper-start.bat执行即可启动。
也可以解压到其他路径，需要修改几个节点目录conf文件夹下的zoo.cfg，修改其中dataDir属性为对应解压目录。

## 2020-10-09
1. 增加msa-sample-web模块，使用NodeJs搭建服务发现组件。
2. NodeJs中关于zookeeper的连接与使用。

##2020-12-17
1. 架构师与技术专家
架构师偏向技术广度，而技术专家更偏向技术深度。
2. 微服务架构师
    * 分析业务需求并切分微服务边界
    * 定义架构规范与文档标准
    * 确保微服务架构顺利落地
    * 改善微服务架构并提高开发效率
3. 微服务与SOA
微服务是SOA的一种落地方案。
SOA是一种面向服务的架构思想，微服务也推崇这种思想。微服务将一个大型的单块架构，拆分为多个细粒度服务的架构。
微服务更加考验的是，深入离接业务并合理的对服务边界进行切分。
4. 微服务辑出设施
    * 注册中心：用于注册微服务相关配置信息的中心，一般基于zookeeper实现。
    * 调用中心：用于提供给前端调用的统一入口，我们选用Node.js实现。
    * 部署中心：用于编译并打包微服务源码并将其部署到Docker引擎中，选用Jenkins实现。
    * 日志中心：用于收集并管理微服务应用程序中产生的日志。
    * 监控中心：用于监控微服务的实时运行状况。
    * 追踪中心：用于最终微服务的调用轨迹。
    * 消息中心：用于解耦微服务之间的调用关系。
    * 配置中心：用于管理微服务应用程序所需的配置参数。


## 2021-03-29
1. 增加spring-boot-admin组件server模块