# Docker安装Registry

## 创建目录

```
mkdir -p /home/docker/registry
```



```

docker run -d \
  -p 5000:5000 \
  --restart=always \
  --name registry \
  -v /home/docker/registry:/var/lib/registry registry
```

