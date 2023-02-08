## RestServer

### 启动程序
```shell
# linux & mac
./mvnw -T 1C clean compile spring-boot:run
# win
./mvnw.cmd -T 1C clean compile spring-boot:run
```

### 测试接口
#### 排序
>排序，暂时只实现了Integer、String、Double&BigDecimal、Integer&String数字 四种排序器

```shell
curl localhost:8080/serv/sort -X POST -d '[1, "11", "05"]' --header "Content-Type: application/json"
```
#### 查询排序记录
```shell
curl localhost:8080/serv/sorts
```


[在线接口文档](https://console-docs.apipost.cn/preview/cf51f85b88f7d0fd/b400d4cf6c4955b8)