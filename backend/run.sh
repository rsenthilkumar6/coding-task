#!/usr/bin/bash

echo "build the project"
mvn clean package

echo "starting the applicaiton"
java -jar target/demo-0.0.1.jar
