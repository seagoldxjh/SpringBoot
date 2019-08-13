# Spring Boot

## Spring boot 简介

1. Spring boot是Spring家族中的一个全新的框架，它用来简化Spring应用程序的创建和开发过程，也可以说Spring boot能简化我们之前采用Spring mvc + Spring + MyBatis 框架进行开发的过程；

2. 在以往我们采用 Spring mvc + Spring + MyBatis 框架进行开发的时候，搭建和整合三大框架，我们需要做很多工作，比如配置web.xml，配置Spring，配置MyBatis，并将它们整合在一起等，而Spring boot框架对此开发过程进行了革命性的颠覆，抛弃了繁琐的xml配置过程，采用大量的默认配置简化我们的开发过程；

3. 所以采用Spring boot可以非常容易和快速地创建基于Spring 框架的应用程序，它让编码变简单了，配置变简单了，部署变简单了，监控变简单了；

4. 正因为 Spring boot 它化繁为简，让开发变得极其简单和快速，所以在业界备受关注；

5. Spring boot 在国内的关注趋势图：http://t.cn/ROQLquP

   

## Spring boot 的特性

1. 能够快速创建基于Spring的应用程序；

2. 能够直接使用java main方法启动内嵌的Tomcat, Jetty 服务器运行Spring boot程序，不需要部署war包文件；

3. 提供约定的starter POM来简化Maven配置，让Maven的配置变得简单；

4. 根据项目的Maven依赖配置，Spring boot自动配置Spring、Spring mvc等；

5. 提供了程序的健康检查等功能；

6. 基本可以完全不使用XML配置文件，采用注解配置；

   

## Spring boot 四大核心

1. 自动配置：针对很多Spring应用程序和常见的应用功能，Spring Boot能自动提供相关配置；
2. 起步依赖：告诉Spring Boot需要什么功能，它就能引入需要的依赖库；

3. Actuator：让你能够深入运行中的Spring Boot应用程序，一探Spring boot程序的内部信息；

4. 命令行界面：这是Spring Boot的可选特性，主要针对 Groovy 语言使用；


   

## 第一个 Spring boot 程序

1. 创建一个Spring boot项目；

   - 可以采用方式一： 使用 eclipse 的 Spring Tool Suite (STS) 插件/或者 IDEA 自带的插件创建；

   - 可以采用方式二：直接使用 Maven 创建项目的方式创建；

2. 加入Spring boot 的父级和起步依赖；

   - 父级依赖：

   ```xml
   <parent>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-parent</artifactId>
       <version>1.5.9.RELEASE</version>
       <relativePath />
   </parent>
   ```

   加入Spring boot父级依赖可以简化我们项目的Maven配置；

   - 起步依赖：

   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-web</artifactId>
   </dependency>
   ```

   加入Spring boot 的起步依赖也可以简化我们项目的Maven配置；

3. 创建Spring boot 的入口main方法

   ```java
   @SpringBootApplication
   public class SpringbootApplication {
   	public static void main(String[] args) {
   		SpringApplication.run(SpringbootApplication.class, args);
   	}
   }
   ```

4. 创建一个Spring mvc 的Controller

   ```java
   @Controller
   public class HelloController {
   	@RequestMapping("/sayHi")
   	public @ResponseBody String sayHi () {
   		return "Hi，Spring boot";
   	}
   }
   ```

5. 运行Spring boot的入口main方法

   通过eclipse、idea右键运行main方法；

   至此，第一个Spring boot程序开发完成；

   

## 第一个 Spring boot 程序解析

1. Spring Boot 的父级依赖spring-boot-starter-parent配置之后，当前的项目就是Spring Boot项目；

2. spring-boot-starter-parent是一个特殊的starter依赖，它用来提供相关的Maven默认依赖，使用它之后，常用的jar包依赖可以省去version配置；

3. Spring Boot提供了哪些默认jar包的依赖，可查看该父级依赖的pom文件；

4. 如果不想使用某个默认的依赖版本，可以通过pom.xml文件的属性配置覆盖各个依赖项，比如覆盖Spring版本：

   ```
   <properties>
       <spring.version>5.0.0.RELEASE</spring.version>
   </properties>
   ```

5. @SpringBootApplication 注解是Spring Boot项目的核心注解，主要作用是开启Spring自动配置；

6. main方法是一个标准的Java程序的main方法，主要作用是作为项目启动运行的入口；

7. @Controller 及 @ResponseBody 依然是我们之前的Spring mvc，因为Spring boot的里面依然是使用我们的Spring mvc + Spring + MyBatis 等框架；

   

## Spring boot 的核心配置文件

Spring boot的核心配置文件用于配置Spring boot程序，有两种格式的配置文件：

1. properties文件

   键值对的properties属性文件配置方式

   - 配置服务器端口：server.port=9800

   - 配置应用访问路径：server.context-path=/13-springboot-web

     

2. yml文件

   yml 是一种 yaml 格式的配置文件，主要采用一定的空格、换行等格式排版进行配置；

   yaml 是一种直观的能够被计算机识别的的数据序列化格式，容易被人类阅读，yaml 类似于 xml，但是语法比 xml 简洁很多；

   值与前面的冒号配置项必须要有一个空格；

   yml 后缀也可以使用 yaml 后缀；

   server:
     port: 9091
     context-path: /13-springboot-web



3. 多环境配置文件

   - 比如配置测试环境

     spring.profiles.active=dev

     application-dev.properties

   - 比如配置生产环境

     spring.profiles.active=product

     application-product.properties

     

## Spring boot 自定义配置

我们可以在Spring boot的核心配置文件中自定义配置，然后采用如下注解去读取配置的属性值；

1. @Value注解

   用于逐个读取自定义的配置，比如：

   ```
   @Value("${bjpowernode.name}")
   private String name;
   ```

2. @ConfigurationProperties

   用于将整个文件映射成一个对象，比如：

   ```
   @Component
   @ConfigurationProperties(prefix="bjpowernode")
   public class MyConfig {
   	private String name;
   	public String getName() {
   		return name;
   	}
   	public void setName(String name) {
   		this.name = name;
   	}
   }
   ```



## Spring boot 使用 JSP

在Spring boot中使用jsp，按如下步骤进行：

1. 在pom.xml文件中配置依赖项

   ```xml
   <!--引入Spring Boot内嵌的Tomcat对JSP的解析包-->
   <dependency>
       <groupId>org.apache.tomcat.embed</groupId>
       <artifactId>tomcat-embed-jasper</artifactId>
   </dependency>
   
   <!-- servlet依赖的jar包start -->
   <dependency>
   	<groupId>javax.servlet</groupId>
   	<artifactId>javax.servlet-api</artifactId>
   </dependency>
   <!-- servlet依赖的jar包start -->
   
   <!-- jsp依赖jar包start -->
   <dependency>
   	<groupId>javax.servlet.jsp</groupId>
   	<artifactId>javax.servlet.jsp-api</artifactId>
   	<version>2.3.1</version>
   </dependency>
   <!-- jsp依赖jar包end -->
   
   <!--jstl标签依赖的jar包start -->
   <dependency>
   	<groupId>javax.servlet</groupId>
   	<artifactId>jstl</artifactId>
   </dependency>
   <!--jstl标签依赖的jar包end -->
   ```

2. 在application.properties文件配置spring mvc的视图展示为jsp：

   spring.mvc.view.prefix=/
   spring.mvc.view.suffix=.jsp

3. 在src/main 下创建一个webapp目录，然后在该目录下新建jsp页面

   build中要配置备注中的配置信息

   ```xml
   <resources>
     <resource>
       <directory>src/main/java</directory>
       <includes>
         <include>**/*.xml</include>
       </includes>
     </resource>
     <resource>
       <directory>src/main/resources</directory>
       <includes>
         <include>**/*.*</include>
       </includes>
     </resource>
     <resource>
       <directory>src/main/webapp</directory>
       <targetPath>META-INF/resources</targetPath>
       <includes>
         <include>**/*.*</include>
       </includes>
     </resource>
   </resources>
   ```

   

## Spring boot 集成 MyBatis

Spring boot 集成 MyBatis的步骤如下：

1. 在pom.xml中配置相关jar依赖；

   ```xml
   <!-- 加载mybatis整合springboot -->
   <dependency>
   	<groupId>org.mybatis.spring.boot</groupId>
   	<artifactId>mybatis-spring-boot-starter</artifactId>
   	<version>1.3.1</version>
   </dependency>
   
   <!-- MySQL的jdbc驱动包 -->
   <dependency>
   	<groupId>mysql</groupId>
   	<artifactId>mysql-connector-java</artifactId>
   </dependency>
   ```

2. 在Springboot的核心配置文件 application.properties 中配置MyBatis的Mapper.xml文件所在位置：
   mybatis.mapper-locations=classpath:com/bjpowernode/springboot/mapper/*.xml

3. 在Springboot的核心配置文件application.properties中配置数据源：

   ```properties
   spring.datasource.username=root
   spring.datasource.password=123456
   spring.datasource.driver-class-name=com.mysql.jdbc.Driver
   spring.datasource.url=?useUnicode=true&characterEncoding=utf8&useSSL=false
   #mysql 8.0.11
   spring.datasource.url=jdbc:mysql://localhost:3306/mp?useUnicode=true&characterEncoding=utf8&useSSL=false
   spring.datasource.username=root
   spring.datasource.password=xjh499954
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   ```

4. 在MyBatis的Mapper接口中添加@Mapper注解 或者 
   在运行的主类上添加 @MapperScan("com.bjpowernode.springboot.mapper") 注解包扫描

   

## Spring boot 事务支持

Spring Boot 使用事务非常简单；

1. 在入口类中使用注解 @EnableTransactionManagement 开启事务支持；

2. 在访问数据库的Service方法上添加注解 @Transactional 即可；

   

## Spring boot整合Email

1. 在pom.xml中配置相关jar依赖；

   ```xml
   <!-- Java Mail -->
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-mail</artifactId>
   </dependency>
   ```

2. 全局配置文件

   ```properties
   #邮箱服务器地址
   spring.mail.host=smtp.qq.com
   #发件人地址
   spring.mail.username=1157418149@qq.com
   #邮箱的授权码
   spring.mail.password=fxhmhhousroshjic
   spring.mail.default-encoding=utf-8
   #发件人
   mail.fromMail.addr=1157418149@qq.com
   ```



## Spring boot 实现 RESTfull API(REST风格，斗鱼房间号)

1. 什么是RESTFull？

   RESTFull 一种互联网软件架构设计的风格，但它并不是标准，它只是提出了一组客户端和服务器交互时的架构理念和设计原则，基于这种理念和原则设计的接口可以更简洁，更有层次；

   任何的技术都可以实现这种理念；

   比如我们要访问一个http接口：http://localhost:80080/api/order?id=1521&status=1

   采用RESTFull风格则http地址为：http://localhost:80080/api/order/1021/1

2. Spring boot开发RESTFull

   Spring boot开发RESTFull 主要是几个注解实现：

   - @PathVariable

     获取url中的数据；

     该注解是实现RESTFull最主要的一个注解；

     ![image-20190715141724838](/Users/xjh/Library/Application Support/typora-user-images/image-20190715141724838.png)

     ![image-20190715141922185](/Users/xjh/Library/Application Support/typora-user-images/image-20190715141922185.png)

   - 增加 post方法（PostMapping）

     接收和处理Post方式的请求；

   - 删除 delete方法（DeleteMapping）

     接收delete方式的请求，可以使用GetMapping代替；

   - 修改 put方法（PutMapping）

     接收put方式的请求，可以用PostMapping代替；

   - 查询 get方法（GetMapping）

     接收get方式的请求；

   

## Spring boot 热部署插件

在实际开发中，我们修改某些代码逻辑功能或页面都需要重启应用，这无形中降低了开发效率；

热部署是指当我们修改代码后，服务能自动重启加载新修改的内容，这样大大提高了我们开发的效率；

Spring boot热部署通过添加一个插件实现；

插件为：spring-boot-devtools，在Maven中配置如下：

```xml
<!-- springboot 开发自动热部署 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
</dependency>
```

该热部署插件在实际使用中会有一些小问题，明明已经重启，但没有生效，这种情况下，手动重启一下程序；



## Spring boot 集成 Redis

Spring boot 集成 Redis 的步骤如下：

1. 在pom.xml中配置相关的jar依赖；

   ```xml
   <!-- 加载spring boot redis包 -->
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-data-redis</artifactId>
   </dependency>
   ```

2. 在Springboot核心配置文件application.properties中配置redis连接信息：

   ```properties
   spring.redis.host=192.168.230.128
   spring.redis.port=6379
   spring.redis.password=123456
   ```

3. 配置了上面的步骤，Spring boot将自动配置RedisTemplate，在需要操作redis的类中注入redisTemplate;

   在使用的类中注入：

   ```java
   @Autowired
   private RedisTemplate<String, String> redisTemplate;
   
   @Autowired
   private RedisTemplate<Object, Object> redisTemplate;
   ```

   ![image-20190715143954549](/Users/xjh/Library/Application Support/typora-user-images/image-20190715143954549.png)

   4. 高并发缓存穿透问题解决（双重同步锁）

      ![image-20190715145132311](/Users/xjh/Library/Application Support/typora-user-images/image-20190715145132311.png)

   spring boot帮我们注入的redisTemplate类，泛型里面只能写 <String, String>、<Object, Object>

   5. 哨兵模式redis集群配置：
        redis:
          password: 123456
          sentinel:
            master: mymaster 
            nodes: 192.168.179.128:26380,192.168.179.128:26382,192.168.179.128:26384

   

## Spring boot 集成 Dubbo

### 集成前的准备

1. 阿里巴巴提供的dubbo集成springboot开源项目；

   https://github.com/alibaba

2. 我们将采用该项目提供的jar包进行集成；

   ```xml
   <!--添加dubbo集成springboot依赖-->
   <dependency>
       <groupId>com.alibaba.spring.boot</groupId>
       <artifactId>dubbo-spring-boot-starter</artifactId>
       <version>1.0.0</version>
   </dependency>
   ```

### 正式集成

开发Dubbo服务接口

按照Dubbo官方开发建议，创建一个接口项目，该项目只定义接口和model类；

public interface UserService {
    public String sayHi (String name);
}

开发Dubbo服务提供者

1、创建一个Springboot项目并配置好相关的依赖；

2、加入springboot与dubbo集成的起步依赖：

<dependency>
    <groupId>com.alibaba.spring.boot</groupId>
    <artifactId>dubbo-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>

3、在Springboot的核心配置文件application.properties中配置dubbo的信息：

# WEB服务端口
server.port=8080
# dubbo配置
spring.dubbo.appname=springboot-dubbo-provider
spring.dubbo.registry=zookeeper://192.168.230.128:2181

由于使用了zookeeper作为注册中心，则需要加入zookeeper的客户端jar包：

<dependency>
    <groupId>com.101tec</groupId>
    <artifactId>zkclient</artifactId>
    <version>0.10</version>
</dependency>

<!-- zookeeper客户端依赖start -->
		<dependency>
			<groupId>com.101tec</groupId>
			<artifactId>zkclient</artifactId>
			<version>0.10</version>
			<exclusions>
				<exclusion>
					<groupId>log4j</groupId>
					<artifactId>log4j</artifactId>
				</exclusion>
				<exclusion>
					<groupId>org.slf4j</groupId>
					<artifactId>slf4j-log4j12</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		<!-- zookeeper客户端依赖end -->

4、编写Dubbo的接口实现类：

import org.springframework.stereotype.Component;
import com.alibaba.dubbo.config.annotation.Service;
import com.bjpowernode.springboot.dubbo.service.UserService;

@Service(interfaceClass = UserService.class) //该注解是dubbo的
@Component //该注解是spring的
public class UserServiceImpl implements UserService {
	@Override
	public String sayHi(String name) {
		return "Hi, " + name;
	}
}

5、编写一个入口main程序启动Dubbo服务提供者：

@SpringBootApplication
@EnableDubboConfiguration //开启dubbo配置支持
public class SpringbootApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}

开发Dubbo服务消费者

1、创建一个Springboot项目并配置好相关的依赖；

2、加入springboot与dubbo集成的起步依赖：

<dependency>
    <groupId>com.alibaba.spring.boot</groupId>
    <artifactId>dubbo-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>

3、在Springboot的核心配置文件application.properties中配置dubbo的信息：

WEB服务端口
server.port=9090
dubbo配置
spring.dubbo.appname=springboot-dubbo-consumer
spring.dubbo.registry=zookeeper://192.168.91.129:2181

由于使用了zookeeper作为注册中心，则需要加入zookeeper的客户端jar包：

<dependency>
    <groupId>com.101tec</groupId>
    <artifactId>zkclient</artifactId>
    <version>0.10</version>
</dependency>

4、编写一个Controller类，调用远程的Dubbo服务：

@Controller
public class UserController {
	@Reference //使用dubbo的注解引用远程的dubbo服务
	private UserService userService;
	@RequestMapping("/sayHi")
	public @ResponseBody String sayHi () {
		return userService.sayHi("spring boot dubbo......");
	}
}

5、编写一个入口main程序启动Dubbo服务提供者：

@SpringBootApplication
@EnableDubboConfiguration //开启dubbo配置支持
public class SpringbootApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}

## Spring boot 使用拦截器

1、按照Spring mvc的方式编写一个拦截器类；

2、编写一个配置类继承WebMvcConfigurerAdapter类

3、为该配置类添加@Configuration注解，标注此类为一个配置类，让Spring boot 扫描到；

4、覆盖其中的方法并添加已经编写好的拦截器：
@Override
public void addInterceptors(InterceptorRegistry registry) {
    //对来自 /api/** 链接的请求进行拦截，对登录请求/api/login不进行拦截
    registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/api/**").excludePathPatterns("/api/login");
}

## Spring boot 程序war包部署

1. 程序入口类需扩展继承 SpringBootServletInitializer 类

2、程序入口类覆盖如下方法：

@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(SpringbootApplication.class);
}

3、更新包为war，在 pom.xml 中修改 <packaging>war</packaging>

4、配置springboot打包的插件

<!-- Springboot打包的插件 -->
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
</plugin>

<resources>
			<resource>
				<directory>src/main/java</directory>
				<includes>
					<include>**/*.xml</include>
				</includes>
			</resource>
			<resource>
				<directory>src/main/resources</directory>
				<includes>
					<include>**/*.*</include>
				</includes>
			</resource>
			<!-- 打包时将jsp文件拷贝到META-INF目录下 -->
			<resource>
				<!-- 指定resources插件处理哪个目录下的资源文件 -->
				<directory>src/main/webapp</directory>
				<!--注意此次必须要放在此目录下才能被访问到 -->
				<targetPath>META-INF/resources</targetPath>
				<includes>
					<include>**/*.*</include>
				</includes>
			</resource>
		</resources>

5、在项目中通过 Maven install 在本地maven仓库安装成一个war包，然后将war包部署到tomcat下运行；

## Spring boot 程序打Jar包与运行

1、Spring boot程序打包，在pom.xml文件加入如下Spring boot的maven插件：

<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>

<build>
	<plugins>
		<plugin>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-maven-plugin</artifactId>
			<version>1.4.2.RELEASE</version>
		</plugin>
	</plugins>
	<resources>
		<resource>
			<directory>src/main/java</directory>
			<includes>
				<include>**/*.xml</include>
			</includes>
		</resource>
		<resource>
			<directory>src/main/resources</directory>
			<includes>
				<include>**/*.*</include>
			</includes>
		</resource>
		<!-- 打包时将jsp文件拷贝到META-INF目录下 -->
		<resource>
			<!-- 指定resources插件处理哪个目录下的资源文件 -->
			<directory>src/main/webapp</directory>
			<!--注意此次必须要放在此目录下才能被访问到 -->
			<targetPath>META-INF/resources</targetPath>
			<includes>
				<include>**/*.*</include>
			</includes>
		</resource>
	</resources>
</build>

上面这个插件打包有小问题，用备注中的配置（插件使用1.4.2版本，其他版本目前测试有问题）

2、在项目中使用 Maven install 在本地maven仓库安装成一个jar；

3、使用java -jar 运行第2步生成的jar包，从而可以启动 Spring boot 程序；

4、访问第3步运行起来的 spring boot程序；

Spring boot 部署与运行方式总结

Spring boot 程序启动运行方式：

1、在IDEA中直接运行spring boot程序的main方法（开发阶段）；

2、用maven将spring boot安装为一个jar包，使用Java命令运行：java -jar  spring-boot-xxx.jar 
可以将该命令封装到一个Linux的一个shell脚本中（上线部署）

1.写一个shell脚本：

#!/bin/sh
java -jar xxx.jar


2.赋权限 chmod 777 run.sh

3.启动shell脚本： ./run.sh


3、使用Spring boot的maven插件将Springboot程序打成war包，单独部署在tomcat中运行（上线部署）；

## spring boot 集成 Spring session

1、配置jar依赖

<dependency>
    <groupId>org.springframework.session</groupId>
    <artifactId>spring-session</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>

2、配置redis连接

spring.redis.host=192.168.230.128
spring.redis.port=6379
spring.redis.password=123456

3、在运行的主类上添加@EnableRedisHttpSession注解

或者在配置文件中加入：spring.session.store-type=redis

