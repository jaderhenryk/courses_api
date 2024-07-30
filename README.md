# Course API
This is a [Spring Boot](https://spring.io/projects/spring-boot) project created for Rocketseat first challenge of Java Course.

## Overview
This project demonstrates how to set up a Spring Boot application with a PostgreSQL database using Docker Compose. The setup ensures that sensitive information like database credentials is securely managed using environment variables.

It uses [Docker](https://www.docker.com/) and [PostgreSQL](https://www.postgresql.org/) data base service.

## Prerequisites

- Java 17
- Maven
- Docker
- Docker Compose

## Getting Started

### 1. Configuring environment variables

Create a .env file in the root of your project and add the following environment variables:

```
POSTGRES_USER=your_database_user
POSTGRES_PASSWORD=your_database_password
POSTGRES_DB=your_database_name
SPRING_DATASOURCE_URL=your_database_host
SPRING_DATASOURCE_USERNAME=your_database_user
SPRING_DATASOURCE_PASSWORD=your_database_password
```

For production environment uses another solution to protect your sensitive data, like [Hashicorp Vault](https://www.vaultproject.io/) or other solutions.

### 2. Build the Spring Boot Application

First, you need to build the Spring Boot application using Maven.

```bash
./mvnw clean package
```

### 3. Build the image and run the containers

Run the command beneath to build the docker app image and deploy both app and database containers.

```
docker compose up --build
```

You can checke the logs of both containers running these commands:

```
docker compose logs app
docker compose logs db
```

### 4. Stopping containers

To stop the containers run this command:

```
docker compose stop
```
or, to completly remove the containers, networks and volumes associated.
```
docker compose down
```