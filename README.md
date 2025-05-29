# 美食地图后端

## 项目配置

1. JDK 版本: Adoptium Eclipse Temurin - OpenJDK 21
2. JDK
   下载路径: [Adoptium Eclipse Temurin - OpenJDK 21](https://adoptium.net/zh-CN/temurin/releases/?version=21&os=windows&arch=x64&package=jdk)

## 打WAR包

1. 执行如下命令
    ```shell
    mvnw clean package -DskipTests -Pbuild_war
    ```