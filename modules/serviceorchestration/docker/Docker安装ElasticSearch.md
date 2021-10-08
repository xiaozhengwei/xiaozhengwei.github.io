# Docker安装Elasticsearch



## 创建单机Elasticsearch



### 创建本地映射文件

```
mkdir -p /home/elasticsearch/config/ /home/elasticsearch/data /home/elasticsearch/plugins;
# touch /home/elasticsearch/config/elasticsearch.yml;
```



### 创建单机ElasticSearch

```shell
docker run \
--name elasticsearch \
-p 9200:9200 \
-p 9300:9300 \
-e "discovery.type=single-node" \
-e ES_JAVA_OPTS="-Xms128m -Xmx128m" \
-v \
/home/elasticsearch/config/elasticsearch.yml:/usr/share/elasticsearch/config/elasticsearch.yml \
-v \
/home/elasticsearch/data:/usr/share/elasticsearch/data \
-v \
/home/elasticsearch/plugins:/usr/share/elasticsearch/plugins \
-d elasticsearch:7.12.0 ;
```

```shell
docker run \
--name kibana \
-e ELASTICSEARCH_HOSTS=http://180.76.100.50:9200 \
-p 5601:5601 \
-d kibana:7.12.0;
```

```shell
# 可选项
-e "ES_JAVA_OPTS=-Xms512m -Xmx512m"

# 其中一个错误的解决方案
sudo sysctl -w vm.max_map_count=262144
```





##  创建Elasticsearch集群

使用docker-componse创建ES集群

docker-compose.yaml文件为:

```yaml
version: '2.2'
services:
  cerebro:
    image: lmenezes/cerebro:0.8.3
    container_name: cerebro
    ports:
      - "9100:9000"
    command:
      - -Dhosts.0.host=http://elasticsearch:9200
    networks:
      - es7net
  kibana:
    image: kibana:7.12.0
    container_name: kibana7
    environment:
      - I18N_LOCALE=zh-CN
      - XPACK_GRAPH_ENABLED=true
      - TIMELION_ENABLED=true
      - XPACK_MONITORING_COLLECTION_ENABLED="true"
    ports:
      - "5601:5601"
    networks:
      - es7net
  elasticsearch:
    image: elasticsearch:7.12.0
    container_name: es7_01
    environment:
      - cluster.name=geektime
      - node.name=es7_01
      - bootstrap.memory_lock=true
      - "ES_JAVA_OPTS=-Xms512m -Xmx512m"
      - discovery.seed_hosts=es7_01,es7_02
      - cluster.initial_master_nodes=es7_01,es7_02
    ulimits:
      memlock:
        soft: -1
        hard: -1
    volumes:
      - es7data1:/usr/share/elasticsearch/data
    ports:
      - 9200:9200
    networks:
      - es7net
  elasticsearch2:
    image: elasticsearch:7.12.0
    container_name: es7_02
    environment:
      - cluster.name=geektime
      - node.name=es7_02
      - bootstrap.memory_lock=true
      - "ES_JAVA_OPTS=-Xms512m -Xmx512m"
      - discovery.seed_hosts=es7_01,es7_02
      - cluster.initial_master_nodes=es7_01,es7_02
    ulimits:
      memlock:
        soft: -1
        hard: -1
    volumes:
      - es7data2:/usr/share/elasticsearch/data
    networks:
      - es7net


volumes:
  es7data1:
    driver: local
  es7data2:
    driver: local

networks:
  es7net:
    driver: bridge

```

