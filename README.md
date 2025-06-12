[![Java Maven Build Test](https://github.com/deepaksorthiya/spring-boot-graalvm-native/actions/workflows/maven-build.yml/badge.svg)](https://github.com/deepaksorthiya/spring-boot-graalvm-native/actions/workflows/maven-build.yml) <br>
[![Docker Pulls](https://img.shields.io/docker/pulls/deepaksorthiya/spring-boot-graalvm-native)](https://hub.docker.com/r/deepaksorthiya/spring-boot-graalvm-native)

---

### ** Spring Boot GraalVM Native Image **

---

# Getting Started

## Requirements:

```
Git: 2.49.0
Spring Boot: 3.5.0
Maven: 3.9+
Java GraalVM: 24
Docker Desktop: Tested on 4.42.0
```

## Clone this repository:

```bash
git clone https://github.com/deepaksorthiya/spring-boot-graalvm-native.git
cd spring-boot-graalvm-native
```

## Build Project:

```bash
./mvnw -Pnative native:compile
```

## Run Project:

```bash
./target/spring-boot-graalvm-native
```

## (Optional)Build Docker Image(docker should be running):

```bash
./mvnw clean -Pnative spring-boot:build-image -DskipTests
```

## (Optional)Running On Docker

```bash
docker run -p 8080:8080 --name spring-boot-graalvm-native deepaksorthiya/spring-boot-graalvm-native
```

## Testing

```bash
./mvnw -PnativeTest test
```

http://localhost:8080

http://localhost:8080/h2-console

## Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/maven-plugin/build-image.html)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/reference/actuator/index.html)
* [Spring Web](https://docs.spring.io/spring-boot/reference/web/servlet.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Validation](https://docs.spring.io/spring-boot//io/validation.html)
* [Flyway Migration](https://docs.spring.io/spring-boot/how-to/data-initialization.html#howto.data-initialization.migration-tool.flyway)

## Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)


