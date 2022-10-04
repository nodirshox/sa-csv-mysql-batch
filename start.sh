#!/bin/bash
echo "Building Docker image..."
docker build --platform linux/amd64 --rm -t spring-batch .
echo "Starting Docker Compose"
docker-compose up -d
