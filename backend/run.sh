#!/usr/bin/bash

echo "build the project"
mvn clean package

if [ -x "$(command -v docker)" ]; then
    echo "docker is available!!"
    echo "building docker image"
    docker build -f Dockerfile -t demo-app .
    docker run -p 9001:9001 demo-app
else
    echo "docker not installed! skipping..."
    echo "starting the application"
    java -jar target/demo-0.0.1.jar
fi