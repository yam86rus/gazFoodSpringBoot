#!/usr/bin/env bash
mvn clean package

echo 'Copy files...'

scp /home/maxim/IdeaProjects/gazFoodSpringBoot/target/GazFoodSpringBoot-0.1.0-SNAPSHOT.jar user@169.168.9.251:/home/user/putHere
