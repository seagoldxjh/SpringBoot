# SpringBoot快速整合SSM,Redis,RabbitMQ常见中间件及其功能实现

## SpringBoot整合RabbitMQ
1. pom.xml中配置相关的jar依赖
```xml
<!-- RabbitMQ消息队列依赖 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
 ```
2. 在Springboot核心配置文件application.properties中配置Rabbit连接信息
```properties
#对于rabbitMQ的支持
spring.rabbitmq.host=127.0.0.1
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
 ```
3. 功能代码实现以及注释见RabbitController
    - Quene
    - Exchange

4. 大致运行原理
生产者（publisher）连接到RabbitMQ服务器实体（Broker）根据用户账号密码找到对应的虚拟主机（每个虚拟主机独立的可以理解为一个单独的Broker），虚拟机将消息交给指定的交换器（Exchange），交换器根据路由键（路由规则[Binding]）将消息发送到对应的队列（Queue）
消费者（Consumer）建立一个TCP连接到消息队列，为了节省资源，每次建立TCP资源耗费资源，采用信道复用技术，在一个TCP连接中开辟多条管道用于数据传输，消费者直接从Queue中获取数据

5. 交换器类型
- Direct:：默认方式，点对点，如果和Binding中的binding-key一致，交换器就将该消息发到对应的队列中。如果一个队列绑定到交换器要求路由键为“dog”，则只转发routing-key标记为dog的消息，它是完全匹配、单播的模式。
- Fanout：类似于多播，每个发到fanout类型交换器的消息都会分到所有绑定的队列上去，fanout交换器不处理路由键，只是简单的将队列绑定到交换器上，每个发送到交换器的消息都会被转发到与该交换器绑定的所有队列上，很像子网广播，每台子网内的主机都获得了一份复制的消息，fanout类型转发消息是最快的。
- Topic：binding-key支持通配符，有两个通配符，“#”代表0个或多个单词，“*”代表一个单词，若消息的routing-key与之匹配，则将消息发至该队列。


## 整合Spring Data Redis
1. 五种基本类型的命令操作方式大致清楚（String,Hash,List,Set,sortedSet）
2. 利用Spring Data Redis操作Redis实现对数据库查询后缓存进入redis
3. 利用Spring Data Redis实现单点登陆
    - 大致思路<id,sessionId>存入redis，拦截器判断用户sessionId是否相同
    - 已实现（LoginInterceptor）
    
### 用的不多
4. redis的发布句订阅（生产者消费者模式）
5. redis事务处理
6. redis悲观锁乐观锁

### redis的持久化（https://segmentfault.com/a/1190000015983518）
1. RDB（Redis DataBase）指定时间间隔内将内存数据集快照写入磁盘，恢复时直接读入内存
2. AOF（Append only file）redis每次接收写操作同时写入aof文件中，redis重启后执行aof恢复数据

### redis集群
1. 主从复制(master/slave) -- replication实现多台服务器的数据同步
    - 主服务器负责写
    - 从服务器同步数据，用于读取
    - 主服务器宕机后需手动将一个从服务器提升为主服务器
2. 哨兵模式（Sentinel）
    自动转移故障，不需要手动提升服务器等级


## 整合MyBatis Plus（极大简化传统Mybatis开发过程）
官网API: https://mp.baomidou.com/guide/

1. insert后自动将id返回给当前对象
2. 自动开启驼峰转换，自动开启危险sql注入
3. 更多示例功能：https://github.com/seagoldxjh/MyBatisPlus_test

## 整合Java Email（基本实现MailController）
1. 文本发送
2. 模版发送
3. 附件携带发送

