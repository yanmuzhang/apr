#!/bin/bash

TZ=Asia/Shanghai
ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
if [ "$envs" = "prod" ];then
    java -Xms$minx -Xmx$max -jar  /opt/apps/app.jar --server.port=$port --spring.profiles.active=$envs --spring.cloud.config.profile=$envs
else
    java -Xms$minx -Xmx$max -jar /opt/apps/app.jar --server.port=$port --spring.profiles.active=$envs --spring.cloud.config.profile=$envs > /var/log/apps/microservice-order.log
fi