#!/usr/bin/env bash
# Деплой прилоежения в тест

echo 'Start maven clean...'
cd /home/maxim/IdeaProjects/gazFoodSpringBoot
mvn clean package

echo 'Start maven package...'
mvn package

echo 'Delete old *.jar from dir test'
ssh user@169.168.9.251 "rm /home/user/app_back/test/GazFoodSpringBoot-0.1.0-SNAPSHOT.jar"

echo 'Copy files to test...'
scp /home/maxim/IdeaProjects/gazFoodSpringBoot/target/GazFoodSpringBoot-0.1.0-SNAPSHOT.jar user@169.168.9.251:/home/user/app_back/test

