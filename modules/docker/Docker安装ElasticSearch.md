# Docker安装ElasticSearch

```shell
docker pull elasticsearch:6.8.3

# 第一个 `elasticsearch` 为容器的名字( 自行编辑 ), 第二个 `elasticsearch` 为镜像/镜像ID( 自行编辑 )
docker run -d -p 9200:9200 -p 9300:9300 --name elasticsearch  `elasticsearch`

# 可选项
# -e "ES_JAVA_OPTS=-Xms512m -Xmx512m"

# 其中一个错误的解决方案
# sudo sysctl -w vm.max_map_count=262144
```