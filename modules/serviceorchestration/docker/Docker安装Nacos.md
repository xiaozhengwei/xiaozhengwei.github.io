# Docker安装Nacos



## 创建目录

```shell
mkdir -p /home/nacos/init.d/ /home/nacos/logs;
```

## 启动Nacos

```shell
docker run -d \
-e PREFER_HOST_MODE=180.76.100.50 \
-e MODE=standalone \
-e SPRING_DATASOURCE_PLATFORM=mysql \
-e MYSQL_SERVICE_HOST=host \
-e MYSQL_SERVICE_PORT=3306 \
-e MYSQL_SERVICE_USER=user \
-e MYSQL_SERVICE_PASSWORD=password \
-e MYSQL_SERVICE_DB_NAME=nacos_config \
-e JVM_XMS=256m \
-e JVM_XMX=256m \
-v /home/nacos/logs:/home/nacos/logs \
-p 8848:8848 \
--name nacos \
--restart=always \
nacos/nacos-server;
```

