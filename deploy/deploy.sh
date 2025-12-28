#!/bin/bash
set -e

ECR_URL=$1
IMAGE_TAG=$2
REGION=ap-south-1

echo "Logging into ECR..."
aws ecr get-login-password --region $REGION \
 | docker login --username AWS --password-stdin $ECR_URL

echo "Pulling image..."
docker pull $ECR_URL:$IMAGE_TAG

echo "Stopping old container (if exists)..."
docker stop app || true
docker rm app || true

echo "Starting new container..."
docker run -d \
  --name app \
  -p 80:8080 \
  $ECR_URL:$IMAGE_TAG

echo "Deployment completed"
