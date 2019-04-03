#!/bin/sh
mvn clean package && docker build -t com.airhacks/agents .
docker rm -f agents || true && docker run -d -p 8080:8080 -p 4848:4848 --name agents com.airhacks/agents 
