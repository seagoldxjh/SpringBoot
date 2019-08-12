# SpringBoot快速整合

## 整合Java Email（基本实现MailController）
1. 文本发送
2. 模版发送
3. 附件携带发送

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

### redis的持久化
1. RDB
2. AOF


## 整合MyBatis Plus

