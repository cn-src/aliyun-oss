[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/cn.javaer/aliyun-spring-boot-starter-oss/badge.svg)](https://maven-badges.herokuapp.com/maven-central/cn.javaer/aliyun-spring-boot-starter-oss)
[![Build Status](https://travis-ci.org/cn-src/aliyun-oss.svg?branch=master)](https://travis-ci.org/cn-src/aliyun-oss)
[![Libraries.io for GitHub](https://img.shields.io/librariesio/github/cn-src/aliyun-oss.svg)](https://libraries.io/github/cn-src/aliyun-oss)

# aliyun-oss
阿里云 OSS 对象存储 Java SDK 封装

# spring boot 集成
1. 添加依赖
```java
<dependency>
    <groupId>cn.javaer.aliyun</groupId>
    <artifactId>aliyun-spring-boot-starter-oss</artifactId>
    <version>1.0.0</version>
</dependency>
```

2. 配置参数(application.properties)
```
aliyun.oss.endpoint=
aliyun.oss.accessKeyId=
aliyun.oss.accessKeySecret=
```

3. 代码使用
```java
    @Autowired
    private OSSClient ossClient;
```

[官方文档:https://help.aliyun.com/product/31815.html?spm=a2c4g.11186623.6.67.7qMiy1](https://help.aliyun.com/product/31815.html?spm=a2c4g.11186623.6.67.7qMiy1)
