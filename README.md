# jy-cloud

[![Build Status](https://cloud.drone.io/api/badges/lanen/jy-cloud/status.svg)](https://cloud.drone.io/lanen/jy-cloud)
[![Build Status](https://travis-ci.org/lanen/jy-cloud.svg?branch=master)](https://travis-ci.org/lanen/jy-cloud)
[![codecov](https://codecov.io/gh/lanen/jy-cloud/branch/master/graph/badge.svg)](https://codecov.io/gh/lanen/jy-cloud)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

jy-cloud make a easy way to create cloud applicaiton.


| Stable Release Version | JDK Version compatibility | Release Date |
| ------------- | ------------- | ------------|
| Working Now  | 1.8+ | 2019-12-1 |

## License

jy-cloud is licensed under **Apache Software License, Version 2.0**.


## docker-compose 快速建立开发环境

* 提供 spring-cloud-paren/docker-compose 快速建立 eureka-server, zipkin-server, zuul-server
* 提供 db/docker-compose 快速建立 mysql, rabbitmq, redis
* 提供 db/mysql 快速建立master/slave 架构，multi-master (分库分表架构）
* 提供 db/redis 快速建立master/slave 哨兵模式， redis-cluster架构
* 提供 db/rabbltmq 快速建立多镜像架构
