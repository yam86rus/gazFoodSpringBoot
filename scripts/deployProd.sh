#!/usr/bin/env bash
# Деплой приложения в прод

echo 'Start maven clean...'
cd /home/maxim/IdeaProjects/gazFoodSpringBoot
mvn clean package

echo 'Start maven package...'
mvn package

echo 'Copy files to prod...'
scp /home/maxim/IdeaProjects/gazFoodSpringBoot/target/GazFoodSpringBoot-0.1.0-SNAPSHOT.jar user@169.168.9.251:/home/user/app_back/prod

