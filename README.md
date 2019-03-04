# 项目说明

在我学习完springcloud之后，一直都想用springcloud将我之前所学的技术知识都整合进去，所以创立了这个项目mcroservice-integration。以后我会将自己工作中用到的技术或者好用的工具类来逐步完善它，你可以把它当作自己的一个组件库来使用，里面的代码会尽我所能地简洁，高可用，争取能在以后工作中拿来即用。

**本项目所用的技术有:**

**前端框架:** layui

**服务器端:**

**后端模板:** thymeleaf

**权限/安全:** Spring Security

**ORM框架:** Mybatis

**容器+MVC框架: ** Spring Boot

**逆向工程工具:** Mybatis Geneator

**搜索框架:** Elasticsearch

**消息队列:** RabbitMQ

**缓存:** Redis

**简化对象封装工具:** Lombok

**负载均衡: ** Ribbon、Feign

**服务熔断:** Hystrix

**分布式配置中心:** Spring Cloud Config

**路由网关:** Zuul



# 项目结构:



# 状态码

**1001:**成功

**1002:**失败





# 项目日志

### 2019.03.03

1.搭建了项目的整体框架。创建了admin-system-8001后台管理模块,搭建了micro-register-7001项目(Eureka注册中心)，以及micro-service-9001(服务提供端)。

2.前端使用了layui为主要框架,后端框架以Spring Boot作为容器框架，MVC采用Spring MVC，ORM使用了Mybatis。整合项目以Spring Cloud为架构,其中注册中心采用了Eureka,负载均衡使用了Feign,安全与权限验证方面采用了Spring Security。

**问题总结:**

**1.thymeleaf版本问题**: 由于我引入的springboot是1.x版本的,默认引入是thymeleaf2.x版本的,改版本会有标签闭合的问题。所以需要将版本更换为3.0.9版本，除了更新thymeleaf的版本，还需要同时更新thymeleaf-layout-dialect至2.2.x以上，否则会报错。

**2.springsecurity问题**: spring security一旦开启了form.login()表单验证，意味着其默认规则就起作用了。首先需要在表单上指定提交的地址,采用post提交，由于spring security有csrf的安全问题(可以禁止),所以不能直接使用ajax登陆。



**遗留问题:**

spring security无法采用ajax提交，账号密码错误无法给出正确提示。



### 2019.03.04

1. 解决了SpringSecurity无法使用ajax提交的问题。这里我采用了取巧的方法，首先将登陆按钮的type类型变为button(必须指定类型，默认的类型是submit)。然后给该按钮的点击事件中采用ajax提交到Controller验证，前端在回调里判断，若验证成功则提交表单，若验证失败则不提交表单，直接提示失败信息。

**问题总结:**

**1.feign使用问题:** 

1）{"timestamp":1551688222232,"status":404,"error":"Not Found","message":"Not Found","path":"/login.do"},出现上述问题的原因是在服务提供方的Controller层没有编写，服务调用方以及服务提供方都需要写Controller，注意服务提供方的Controll返回值要与服务调用方的**调用方法**一致.

2）Caused by: java.lang.IllegalStateException: Method has too many Body parameters: public abstract com.wxy.micro.model.SystemUser com.wxy.micro.service.SystemUserService.getUserByUsernameAndPassword(java.lang.String,java.lang.String)

出现这个问题的原因是因为Feign API服务接口方法的参数需要加上@RequestParam("username")，而且对象最好加上@RequestBody,且参数里最多有一个对象。