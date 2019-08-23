# redis cluster

利用`docker-compose` 快速建立集群

操作：

0. ./init
1. docker-compose up
2. ./join
3. ./join_confirm
4. ./join check cluster_node1_1 2001


如果中间出错，需要：

1. docker-compose down
2. rm -rf redis_data*
3. 重新开始
