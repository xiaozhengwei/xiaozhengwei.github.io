# 服务治理 : Eureka

## 搭建 Eureka 服务治理中心

**IDEA新建 Spring Initializr 模块 : eureka-server**

在pom.xml中加入依赖:

```pom
<!--    Eureka依赖    -->
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>
</dependencies>

<!--    SpringCloud的POM依赖    -->
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>Hoxton.SR6</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>

```

编辑application.yml
```yml



```
