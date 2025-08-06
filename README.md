 Project Overview

This project contains two Spring Boot microservices that:
- Communicate internally using SOAP
- Expose REST APIs externally
---

##  Features

###  User Service
- `POST /users` → Register a new user
- `GET /users/{id}` → Get user by ID
- `GET /users` → List all users
- SOAP Endpoint: `getUserById`

###  Profile Service
- `POST /profiles` → Create a new profile (calls User Service via SOAP)
- `GET /profiles/{id}` → Retrieve profile along with user data

---

##  Technologies Used

- Java 17+
- Spring Boot
- Spring Web (REST)
- Spring-WS (SOAP)
- H2 or PostgreSQL Database
- Maven
- Swagger/OpenAPI
- DTOs, Layered Architecture (Controller, Service, Repository)
- Lombok

---

##  Getting Started

### Prerequisites

Make sure you have the following installed:

- Java 17+
- Maven 3.5+
- PostgreSQL

---

## Installation & Running

###  User Service

```bash
cd user-service
mvn clean install
mvn spring-boot:run
```

- Runs on: `http://localhost:8081`
- Swagger UI: `http://localhost:8081/swagger-ui/index.html`
- SOAP WSDL URL: `http://localhost:8081/ws/users.wsdl`

### Profile Service

```bash
cd profile-service
mvn clean install
mvn spring-boot:run
```

- Runs on: `http://localhost:8082`
- Swagger UI: `http://localhost:8082/swagger-ui/index.html`

---

## API Reference

### User Service – REST

| Method | Endpoint     | Description         |
|--------|--------------|---------------------|
| POST   | `/users`     | Register new user   |
| GET    | `/users`     | List all users      |
| GET    | `/users/{id}`| Get user by ID      |

### User Service – SOAP

- Endpoint: `/ws/users.wsdl`
- Operation: `getUserById(id: Long)`

### Profile Service – REST

| Method | Endpoint        | Description                          |
|--------|------------------|--------------------------------------|
| POST   | `/profiles`      | Create new profile (validates user)  |
| GET    | `/profiles/{id}` | Get profile + user info              |

---

## Configuration

### User Service – `application.properties`

```properties
server.port=8081

spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=ipsec@21
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

springdoc.swagger-ui.enabled=true
```

### Profile Service – `application.properties`

```properties
server.port=8082

spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=ipsec@21
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

springdoc.swagger-ui.enabled=true
```

##  Documentation

- Swagger UI provides REST documentation for both services.
- WSDL provides SOAP service contract for `getUserById`.

---
