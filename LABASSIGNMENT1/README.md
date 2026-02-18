# SmartMove Backend System

## Requirements
- Java 17
- Maven
- Docker

## Build Project
mvn clean install

## Run Tests with Coverage
mvn clean verify


## Start SonarQube
docker-compose up -d

Access:
http://localhost:9000

## Run static Analysis
mvn sonar:sonar \
-Dsonar.projectKey=smartmove \
-Dsonar.host.url=http://localhost:9000
-Dsonar.login=YOUR_TOKEN
