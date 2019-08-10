#Spring Boot

##Spring boot 简介

1. Spring boot是Spring家族中的一个全新的框架，它用来简化Spring应用程序的创建和开发过程，也可以说Spring boot能简化我们之前采用Spring mvc + Spring + MyBatis 框架进行开发的过程；

2. 在以往我们采用 Spring mvc + Spring + MyBatis 框架进行开发的时候，搭建和整合三大框架，我们需要做很多工作，比如配置web.xml，配置Spring，配置MyBatis，并将它们整合在一起等，而Spring boot框架对此开发过程进行了革命性的颠覆，抛弃了繁琐的xml配置过程，采用大量的默认配置简化我们的开发过程；

3. 所以采用Spring boot可以非常容易和快速地创建基于Spring 框架的应用程序，它让编码变简单了，配置变简单了，部署变简单了，监控变简单了；

4. 正因为 Spring boot 它化繁为简，让开发变得极其简单和快速，所以在业界备受关注；

5. Spring boot 在国内的关注趋势图：http://t.cn/ROQLquP

   

##Spring boot 的特性

1. 能够快速创建基于Spring的应用程序；

2. 能够直接使用java main方法启动内嵌的Tomcat, Jetty 服务器运行Spring boot程序，不需要部署war包文件；

3. 提供约定的starter POM来简化Maven配置，让Maven的配置变得简单；

4. 根据项目的Maven依赖配置，Spring boot自动配置Spring、Spring mvc等；

5. 提供了程序的健康检查等功能；

6. 基本可以完全不使用XML配置文件，采用注解配置；

   

##Spring boot 四大核心

1. 自动配置：针对很多Spring应用程序和常见的应用功能，Spring Boot能自动提供相关配置；
2. 起步依赖：告诉Spring Boot需要什么功能，它就能引入需要的依赖库；

3. Actuator：让你能够深入运行中的Spring Boot应用程序，一探Spring boot程序的内部信息；

4. 命令行界面：这是Spring Boot的可选特性，主要针对 Groovy 语言使用；



##Spring boot 开发环境

1. 推荐使用Spring boot最新版本，目前 Spring Boot 最新正式版为1.5.9.RELEASE；

2. 如果是使用 eclipse，推荐安装 Spring Tool Suite (STS) 插件；

3. 如果使用 IDEA 旗舰版，自带了Springboot插件；

4. 推荐使用 Maven 3.2+，Maven目前最新版本为 3.5.2；

5. 推荐使用 Java 8，虽然 Spring boot 也兼容 Java 6；

   

##第一个 Spring boot 程序

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

   

##第一个 Spring boot 程序解析

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

   

##Spring boot 的核心配置文件

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

     

##Spring boot 自定义配置

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



##Spring boot 使用 JSP

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

   

##Spring boot 集成 MyBatis

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

   

##Spring boot 事务支持

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



##Spring boot 实现 RESTfull API(REST风格，斗鱼房间号)

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

   

##Spring boot 热部署插件

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



##Spring boot 集成 Redis

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

   

##Spring boot 集成 Dubbo

###集成前的准备

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

###正式集成

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

# WEB服务端口
server.port=9090
# dubbo配置
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

##Spring boot 使用拦截器

1、按照Spring mvc的方式编写一个拦截器类；

2、编写一个配置类继承WebMvcConfigurerAdapter类

3、为该配置类添加@Configuration注解，标注此类为一个配置类，让Spring boot 扫描到；

4、覆盖其中的方法并添加已经编写好的拦截器：
@Override
public void addInterceptors(InterceptorRegistry registry) {
    //对来自 /api/** 链接的请求进行拦截，对登录请求/api/login不进行拦截
    registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/api/**").excludePathPatterns("/api/login");
}



##Spring boot 中使用 Servlet

方式一

通过注解方式实现；

1、使用Servlet3的注解方式编写一个Servlet

@WebServlet(urlPatterns="/myServlet")
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = -4134217146900871026L;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("hello word");
        resp.getWriter().flush();
        resp.getWriter().close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

2、在main方法的主类上添加注解：@ServletComponentScan(basePackages="com.bjpowernode.servlet")

方式二

通过Spring boot的配置类实现；

1、编写一个普通的Servlet

public class HeServlet extends HttpServlet {
    private static final long serialVersionUID = -4134217146900871026L;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("hello word");
        resp.getWriter().flush();
        resp.getWriter().close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

2、编写一个Springboot的配置类；

@Configuration
public class ServletConfig {
    @Bean
    public ServletRegistrationBean heServletRegistrationBean(){
        ServletRegistrationBean registration = new ServletRegistrationBean(new HeServlet(), "/servlet/heServlet");
        return registration;
    }
}

Spring boot 中使用 Filter

方式一

通过注解方式实现；

1、编写一个Servlet3的注解过滤器；

@WebFilter(urlPatterns="/*")
public class MyFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("您已进入filter过滤器，您的请求正常，请继续遵规则...");
		chain.doFilter(request, response);
	}
	@Override
	public void destroy() {
	}
}

2、在main方法的主类上添加注解：@ServletComponentScan(basePackages={"com.bjpowernode.springboot.servlet", "com.bjpowernode.springboot.filter"})

方式二

通过Spring boot的配置类实现；

1、编写一个普通的Filter

public class HeFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("he您已进入filter过滤器，您的请求正常，请继续遵规则...");
		chain.doFilter(request, response);
	}
	@Override
	public void destroy() {
	}
}

2、编写一个Springboot的配置类；

@Configuration
public class ServletConfig {
    @Bean
    public ServletRegistrationBean heServletRegistrationBean(){
        ServletRegistrationBean registration = new ServletRegistrationBean(new HeServlet(), "/servlet/heServlet");
        return registration;
    }
    @Bean
    public ServletRegistrationBean sheServletRegistrationBean(){
        ServletRegistrationBean registration = new ServletRegistrationBean(new SheServlet(), "/servlet/sheServlet");
        return registration;
    }
    @Bean
    public FilterRegistrationBean heFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new HeFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }
}

Spring boot 项目配置字符编码

1、第一种方式是使用传统的Spring提供给的字符编码过滤器：

@Bean
public FilterRegistrationBean filterRegistrationBean() {
    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
    characterEncodingFilter.setForceEncoding(true);
    characterEncodingFilter.setEncoding("UTF-8");
    registrationBean.setFilter(characterEncodingFilter);
    registrationBean.addUrlPatterns("/*");
    return registrationBean;
}

在主类上需要扫描此过滤器，扫描包或者class：basePackageClasses=org.springframework.web.filter.CharacterEncodingFilter.class

注意：只有当spring.http.encoding.enabled=false配置成false后，过滤器才会起作用；
标记: 深绿

2、第二种方式是在application.properties中配置字符编码：

从springboot1.4.2之后开始新增的一种字符编码设置；

spring.http.encoding.charset=UTF-8
spring.http.encoding.enabled=true
spring.http.encoding.force=true

Spring Boot 非web应用程序

在 Spring Boot 框架中，要创建一个非Web应用程序（纯Java程序）：

方式一：

1、Spring boot 的入口类实现CommandLineRunner接口；

Java项目起步依赖配置：

<!-- Springboot开发java项目的起步依赖 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
</dependency>

2、覆盖CommandLineRunner接口的run()方法，run方法中编写具体的处理逻辑即可；

@Autowired
private HelloMessageService helloMessageService;

@Override
public void run(String... args) throws Exception {
    System.out.println("hello world!");
    String ss = helloMessageService.getMessage("aaa111");
    System.out.println(ss);
}

方式二：

直接在main方法中，根据SpringApplication.run()方法获取返回的Spring容器对象，再获取业务bean进行调用；

public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(SpringBootConsoleApplication.class, args);
    HelloMessageService helloMessageService = (HelloMessageService)context.getBean("helloMessageService");
    String hi = helloMessageService.getMessage("springboot main");
    System.out.println(hi);
}

小Tip
标记: 深灰

关闭spring logo图标 日志输出：

SpringApplication springApplication = new SpringApplication(SpringBootConsoleApplication.class);
springApplication.setBannerMode(Banner.Mode.OFF);
springApplication.run(args);

Spring boot 程序war包部署

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

Spring boot 程序打Jar包与运行

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

spring boot 集成 Spring session

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

Spring boot 集成 Thymeleaf 模板

认识Thymeleaf

Thymeleaf是一个流行的模板引擎，该模板引擎采用Java语言开发；

模板引擎是一个技术名词，是跨领域跨平台的概念，在Java语言体系下有模板引擎，在C#、PHP语言体系下也有模板引擎，甚至在JavaScript中也会用到模板引擎技术；

Java生态下的模板引擎有 Thymeleaf 、Freemaker、Velocity、Beetl（国产） 等；

Thymeleaf模板既能用于web环境下，也能用于非web环境下，在非web环境下，它能直接显示模板上的静态数据，在web环境下，它能像JSP一样从后台接收数据并替换掉模板上的静态数据；

Thymeleaf 它是基于HTML的，以HTML标签为载体，Thymeleaf 要寄托在HTML的标签下实现对数据的展示；

Thymeleaf的官方网站：http://www.thymeleaf.org

Spring boot 集成了thymeleaf模板技术，并且spring boot官方也推荐使用thymeleaf来替代JSP技术；

thymeleaf是另外的一种模板技术，它本身并不属于springboot，springboot只是很好地集成这种模板技术，作为前端页面的数据展示；

Spring boot 集成 Thymeleaf

1、第一步：在Maven中引入Thymeleaf的依赖，加入以下依赖配置即可：

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>

2、第二步：在Spring boot的核心配置文件application.properties中对Thymeleaf进行配置：

#开发阶段，建议关闭thymeleaf的缓存
spring.thymeleaf.cache=false
#使用遗留的html5以去掉对html标签的校验
spring.thymeleaf.mode=LEGACYHTML5

在使用springboot的过程中，如果使用thymeleaf作为模板文件，则要求HTML格式必须为严格的html5格式，必须有结束标签，否则会报错；

如果不想对标签进行严格的验证，使用spring.thymeleaf.mode=LEGACYHTML5去掉验证，去掉该验证，则需要引入如下依赖，否则会报错：

<dependency>
    <groupId>net.sourceforge.nekohtml</groupId>
    <artifactId>nekohtml</artifactId>
</dependency>

<dependency>
    <groupId>org.unbescape</groupId>
    <artifactId>unbescape</artifactId>
    <version>1.1.5.RELEASE</version>
</dependency>

NekoHTML是一个Java语言的 HTML扫描器和标签补全器 ,这个解析器能够扫描HTML文件并“修正”HTML文档中的常见错误。
NekoHTML能增补缺失的父元素、自动用结束标签关闭相应的元素，修复不匹配的内嵌元素标签等；

3、第三步：写一个Controller去映射到模板页面（和SpringMVC基本一致），比如：

@RequestMapping("/index")
public String index (Model model) {
    model.addAttribute("data", "恭喜，Spring boot集成 Thymeleaf成功！");
    //return 中就是你页面的名字（不带.html后缀）
    return "index";
}

4、第四步：在src/main/resources的templates下新建一个index.html页面用于展示数据：

HTML页面的<html>元素中加入以下属性：<html xmlns:th="http://www.thymeleaf.org">

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8"/>
<title>Spring boot集成 Thymeleaf</title>
</head>
<body>
<p th:text="${data}">Spring boot集成 Thymeleaf</p>
</body>
</html>

Springboot使用thymeleaf作为视图展示，约定将模板文件放置在src/main/resource/templates目录下，静态资源放置在src/main/resource/static目录下
标记: 紫色

Thymeleaf 的标准表达式

Thymeleaf 的标准表达式主要有如下几类：

1、标准变量表达式

语法：${...}

变量表达式用于访问容器（tomcat）上下文环境中的变量，功能和 JSTL 中的 ${} 相同；

Thymeleaf 中的变量表达式使用 ${变量名} 的方式获取其中的数据

比如在Spring mvc 的 Controllar中使用model.addAttribute向前端传输数据，代码如下：

@RequestMapping(value="/userinfo")
public String userinfo (Model model) {
    User user = new User();
    user.setId(1);
    user.setNick("昵称");
    user.setPhone("13700020000");
    user.setAddress("北京大兴");
    model.addAttribute("user", user);
    model.addAttribute("hello", "helloworld");
    return "user";
}

前端接收代码：

<span th:text="${user.nick}">x</span>
<span th:text="${user.phone}">137xxxxxxxx</span>
<span th:text="${user.email}">xxx@xx.com</span>
<span th:text="${user.address}">北京.xxx</span>

<span th:text="${hello}">你好</span>

其中，th:text="" 是Thymeleaf的一个属性，用于文本的显示；

2、选择变量表达式

语法：*{...}

选择变量表达式，也叫星号变量表达式，使用 th:object 属性来绑定对象，比如：

@RequestMapping(value="/userinfo")
public String userinfo (Model model) {
    User user = new User();
    user.setId(1);
    user.setNick("昵称");
    user.setPhone("13700020000");
    user.setAddress("北京大兴");
    model.addAttribute("user", user);
    model.addAttribute("hello", "helloworld");
    return "user";
}

前端接收代码

<div th:object="${user}" >
    <p>nick: <span th:text="*{nick}">张</span></p>
    <p>phone: <span th:text="*{phone}" >三</span></p>
    <p>email: <span th:text="*{email}" >北京</span></p>
    <p>address: <span th:text="*{address}" >北京</span></p>
</div>

选择表达式首先使用th:object来邦定后台传来的User对象，然后使用 * 来代表这个对象，后面 {} 中的值是此对象中的属性；

选择变量表达式 *{...} 是另一种类似于变量表达式 ${...} 表示变量的方法；

选择变量表达式在执行时是在选择的对象上求解，而${...}是在上下文的变量Model上求解；

通过 th:object 属性指明选择变量表达式的求解对象；

上述代码等价于：

<div>
    <p>nick: <span th:text="${user.nick}">张</span></p>
    <p>phone: <span th:text="${user.phone}" >三</span></p>
    <p>email: <span th:text="${user.email}" >北京</span></p>
    <p>address: <span th:text="${user.address}" >北京</span></p>
</div>

标准变量表达式和选择变量表达式可以混合一起使用，比如：

<div th:object="${user}" >
    <p>nick: <span th:text="*{nick}">张</span></p>
    <p>phone: <span th:text="${user.phone}" >三</span></p>
    <p>email: <span th:text="${user.email}" >北京</span></p>
    <p>address: <span th:text="*{address}" >北京</span></p>
</div>

也可以不使用 th:object 进行对象的选择，而直接使用 *{...} 获取数据，比如：

<div>
    <p>nick: <span th:text="*{user.nick}">张</span></p>
    <p>phone: <span th:text="*{user.phone}" >三</span></p>
    <p>email: <span th:text="*{user.email}" >北京</span></p>
    <p>address: <span th:text="*{user.address}" >北京</span></p>
</div>

3、URL表达式

语法：@{...}

URL表达式可用于 <script src="...">、<link href="...">、<a href="...">等

1、绝对URL，比如： 

<a href="info.html" th:href="@{'http://localhost:8080/boot/user/info?id='+${user.id}}">查看</a>

2、相对URL，相对于页面，比如：

<a href="info.html" th:href="@{'user/info?id='+${user.id}}">查看</a>

3、相对URL，相对于项目上下文，比如：

<a href="info.html" th:href="@{'/user/info?id='+${user.id}}">查看</a> （项目的上下文名会被自动添加）

Thymeleaf 的常见属性

如下为thymeleaf的常见属性：

th:action

定义后台控制器的路径，类似<form>标签的action属性，比如：

<form id="login" th:action="@{/login}">......</form>
th:each

 这个属性非常常用，比如从后台传来一个对象集合那么就可以使用此属性遍历输出，它与JSTL中的<c: forEach>类似，此属性既可以循环遍历集合，也可以循环遍历数组及Map，比如：

<tr th:each="user, interStat : ${userlist}">
    <td th:text="${interStat.index}"></td>
    <td th:text="${user.id}"></td>
    <td th:text="${user.nick}"></td>
    <td th:text="${user.phone}"></td>
    <td th:text="${user.email}"></td>
    <td th:text="${user.address}"></td>
</tr>

以上代码解读如下：

th:each="user, iterStat : ${userlist}" 中的 ${userList} 是后台传来的Key，
user是${userList} 中的一个数据，
iterStat 是 ${userList} 循环体的信息，
其中user及iterStat自己可以随便写；

interStat是循环体的信息，通过该变量可以获取如下信息：

index、size、count、even、odd、first、last，其含义如下：

index: 当前迭代对象的index（从0开始计算）
count: 当前迭代对象的个数（从1开始计算）
size: 被迭代对象的大小
current: 当前迭代变量
even/odd: 布尔值，当前循环是否是偶数/奇数（从0开始计算）
first: 布尔值，当前循环是否是第一个
last: 布尔值，当前循环是否是最后一个

注意：循环体信息interStat也可以不定义，则默认采用迭代变量加上Stat后缀，即userStat

Map类型的循环：  

<div th:each="myMapVal : ${myMap}">
    <span th:text="${myMapVal.key}"></span>
    <span th:text="${myMapVal.value}"></span>
    <br/>
</div>

${myMapVal.key} 是获取map中的key，${myMapVal.value} 是获取map中的value；

数组类型的循环：  

<div th:each="myArrayVal : ${myArray}">
    <div th:text="${myArrayVal}"></div>
</div> 

th:href

 定义超链接，比如：

<a  class="login" th:href="@{/login}">登录</a>

th:id

类似html标签中的id属性，比如：

<span th:id="${hello}">aaa</span>

th:if

条件判断，比如后台传来一个变量，判断该变量的值，1为男，2为女：

<span th:if="${sex} == 1" >
	男：<input type="radio" name="se"  th:value="男" />
</span>
<span th:if="${sex} == 2">
	女：<input type="radio" name="se" th:value="女"  />
</span>

th:unless

th:unless是th:if的一个相反操作，上面的例子可以改写为：

<span th:unless="${sex} == 1" >
	女：<input type="radio" name="se"  th:value="女" />
</span>
<span th:unless="${sex} == 2">
	男：<input type="radio" name="se" th:value="男"  />
</span>

th:switch/th:case

switch，case判断语句，比如：

<div th:switch="${sex}">
  <p th:case="1">性别：男</p>
  <p th:case="2">性别：女</p>
  <p th:case="*">性别：未知</p>
</div>

一旦某个case判断值为true，剩余的case则都当做false，“*”表示默认的case，前面的case都不匹配时候，执行默认的case；

th:object

用于数据对象绑定

通常用于选择变量表达式（星号表达式）

th:src

用于外部资源引入，比如<script>标签的src属性，<img>标签的src属性，常与@{}表达式结合使用；

<script th:src="@{/static/js/jquery-2.4.min.js}"></script>
<img th:src="@{/static/image/logo.png}"/>

th:text

用于文本的显示，比如：

<input type="text" id="realName" name="reaName" th:text="${realName}">

th:value

类似html标签中的value属性，能对某元素的value属性进行赋值，比如：

<input type="hidden" id="userId" name="userId" th:value="${userId}">

th:attr

该属性也是用于给HTML中某元素的某属性赋值，但该方式写法不够优雅，比如上面的例子可以写成如下形式：

<input type="hidden" id="userId" name="userId" th:attr="value=${userId}" >

Thymeleaf 字面量

文本字面量

用单引号'...'包围的字符串为文本字面量，比如：

<a th:href="@{'api/getUser?id=' + ${user.id}}">修改</a>

数字字面量

<p>今年是<span th:text="2017">1949</span>年</p>
<p>20年后, 将是<span th:text="2017 + 20">1969</span>年</p>
boolean字面量

true和false

<p th:if="${isFlag} == false">
false在花括号外面，解析识别由Thymleaf自身完成
</p>

<p th:if="${isFlag == true}">
false写在花括号里面，解析识别由SpringEL完成
</p>

null字面量

<p th:if="${userlist == null}">
userlist为空
</p>

<p th:if="${userlist != null}">
userlist不为空
</p>

Thymeleaf 字符串拼接

一种是字面量拼接：

<a href="#" th:text="'第'+${sex}+'页 ,共'+${sex}+'页'"></a>

另一种更优雅的方式，使用“|”减少了字符串的拼接：

<a href="#" th:text="|第${sex}页，共${sex}页|"></a>

Thymeleaf 三元运算判断

<span th:text="${sex eq '1'} ? '男' : '女'">未知</span>

Thymeleaf 运算和关系判断

算术运算：+ , - , * , / , %

关系比较: > , < , >= , <= ( gt , lt , ge , le )

相等判断：== , != ( eq , ne )

Thymaleaf 表达式基本对象

1、模板引擎提供了一组内置的对象，这些内置的对象可以直接在模板中使用，这些对象由#号开始引用：

2、官方手册：http://t.cn/RHsbZpk



#ctx：上下文对象

#vars：上下文变量

#locale: 上下文语言环境.

#httpServletRequest： (仅在web上下文)相当于HttpServletRequest 对象，这是2.x版本，若是3.x版本使用 #request；

#httpSession： (仅在web上下文)相当于HttpSession 对象，这是2.x版本，若是3.x版本使用#session； 需要在后台controller中设置了session

Thymaleaf 表达式功能对象

1、模板引擎提供的一组功能性内置对象，可以在模板中直接使用这些对象提供的功能方法：

2、工作中常使用的数据类型，如集合，时间，数值，可以使用thymeleaf的提供的功能性对象来解析他们；

3、内置功能对象前都需要加#号，内置对象一般都以s结尾；

4、官方手册：http://t.cn/RHs5O6z



#dates: java.util.Date对象的实用方法，<span th:text="${#dates.format(curDate, 'yyyy-MM-dd HH:mm:ss')}"></span>

#calendars: 和dates类似, 但是 java.util.Calendar 对象；

#numbers: 格式化数字对象的实用方法；

#strings: 字符串对象的实用方法： contains, startsWith, prepending/appending等；

#objects: 对objects操作的实用方法；

#bools: 对布尔值求值的实用方法；

#arrays: 数组的实用方法；

#lists: list的实用方法，比如<span th:text="${#lists.size(datas)}"></span>

#sets: set的实用方法；

#maps: map的实用方法；

#aggregates: 对数组或集合创建聚合的实用方法；

Thymeleaf 在 SpringBoot 中的配置大全：

Thymeleaf的配置文件说明：

#spring.thymeleaf.cache = true ＃启用模板缓存。

#spring.thymeleaf.check-template = true ＃在呈现模板之前检查模板是否存在。

#spring.thymeleaf.check-template-location = true ＃检查模板位置是否存在。

#spring.thymeleaf.content-type = text/html ＃Content-Type值。

#spring.thymeleaf.enabled = true ＃启用MVC Thymeleaf视图解析。

#spring.thymeleaf.encoding = UTF-8 ＃模板编码。

#spring.thymeleaf.excluded-view-names = ＃应该从解决方案中排除的视图名称的逗号分隔列表。

#spring.thymeleaf.mode = HTML5 ＃应用于模板的模板模式。另请参见StandardTemplateModeHandlers。

#spring.thymeleaf.prefix = classpath:/templates/ ＃在构建URL时预先查看名称的前缀。

#spring.thymeleaf.suffix = .html ＃构建URL时附加到查看名称的后缀。

#spring.thymeleaf.template-resolver-order = ＃链中模板解析器的顺序。

#spring.thymeleaf.view-names = ＃可以解析的视图名称的逗号分隔列表。

Spring boot Actuator

在生产环境中，需要实时或定期监控服务的可用性，spring-boot 的 actuator 功能提供了很多监控所需的接口。

actuator是spring boot提供的对应用系统的自省和监控的集成功能，可以对应用系统进行配置查看、相关功能统计等；

如何使用该功能呢？

1、在项目的Maven中添加如下依赖：

<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-actuator</artifactId>  
</dependency>  

2、application.properties 或 application.yml 配置文件中指定监控的HTTP端口；

如果不指定，则使用和server相同的端口，比如：

#服务运行的端口
server.port=8100

#actuator监控的端口（端口可配可不配）
management.port=8080
#关闭安全鉴权
management.security.enabled=false

访问举例：http://localhost:8080/health

actuator 提供的主要功能：

HTTP方法	路径	描述	鉴权

GET	/autoconfig	查看自动配置的使用情况	  true

GET	/configprops	查看配置属性，包括默认配置	true

GET	/beans	查看bean及其关系列表	true

GET	/dump	打印线程栈	true

GET	/env	查看所有环境变量	true

GET	/env/{name}	查看具体变量值	true

GET	/health	查看应用健康指标	false

GET	/info	查看应用信息	false

GET	/mappings	查看所有url映射	true

GET	/metrics	查看应用基本指标	true

GET	/metrics/{name}	查看具体指标	true

GET	/trace	查看基本追踪信息	true

POST	/shutdown	关闭应用	true

其中：

1、/info 需要自己在application.properties配置文件中添加信息：

info.contact.email=bjpowernode@163.com
info.contact.phone=010-84846003

然后请求才会有数据；

2、/shutdown 需要在配置文件中开启才能生效：

endpoints.shutdown.enabled=true

3、/trace 记录最近100个请求的信息；

Spring boot 综合案例

通过上面内容的学习，我们完成一个综合案例：

采用 Springboot + dubbo + mybatis + redis + Thymeleaf 实现对数据库的增删改查以及缓存操作； 

具体需求如下：

MySQL数据库中有一张表 u_user；

前端使用 thymeleaf 模板技术展示数据；
标记: 红色

后端使用 spring boot + dubbo + mybatis + redis 实现对数据库数据的增删改查以及缓存操作；

查询数据后将数据放入redis缓存中，减少对数据库的直接访问；

作业的主要目的是练习Springboot如何集成各类技术进行项目开发；

总结

采用Spring Boot开发实质上也是一个常规的Spring项目开发；

只是利用了Spring Boot启动程序和自动配置简化开发过程，提高开发效率；

Spring boot项目开发代码的实现依然是使用Spring mvc + spring + mybatis 等，当然能集成几乎所有的开源项目；

采用Spring boot开发，需要掌握大量的注解，所以日常开发中注意对注解的积累；
