## architect-microservice
《架构探险-轻量级微服务架构》阅读笔记，希望借助于这本书搭建一套轻量级的微服务框架，理解微服务的实现原理。

## 2020-09-28
1. 通过zookeeper实现springboot服务启动注册功能
2. 基于docker启动的zookeeper连接注册失败，最终采用windows环境下的伪集群方式搭建
3. zookeeper集群搭建方式（https://www.jianshu.com/p/3047599c13c7），也可以通过百度网盘下载直接使用（链接：https://pan.baidu.com/s/17sepmZyq6rpvrLQPJVCttA 提取码：6ynt ）解压后放到d盘下根目录下，进入文件夹zookeeper-start.bat执行即可启动。
也可以解压到其他路径，需要修改几个节点目录conf文件夹下的zoo.cfg，修改其中dataDir属性为对应解压目录。