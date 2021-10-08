## 基本操作

- 检索 : docker  search 		关键字
- 拉取 : docker  pull                  镜像名
- 列表 : docker  images            查看所有本地镜像
- 删除 : docker  rmi  `image_id`  删除本地镜像



## 容器操作

```shell
# 根据镜像启动容器
docker run --name  containerName -d  softwareName:tag --restart=always
#   -d : 后台运行
#   -p : 本地端口:服务端口
#   --name  :   容器名称
#   --restart=always : docker服务器重启,容器也跟着一起重启
#   containerName  :   容器自定义名字
#   softwareName : 启动的镜像名字
#   tag : 标签/版本
```

```shell
# 查看正在运行的容器
docker ps  [-a : 所有的]
```



```shell
# 启动已经终止的容器
docker container start `containerid`
```



```shell
# 停止一个容器
docker stop `containerid`
```



```shell
# 删除一个容器
docker rm `containerid`
```



```shell
# 随着docke服务的重启,自动重启(对于已经运行的容器)
docker update --restart=always 
```



```shell
# 查询容器日志
docker logs `containerid`
```



```shell
# 进入docker容器
docker exec -it `containerid` bash
```



```shell
# 查看容器信息
docker inspect `containerid` 
```

