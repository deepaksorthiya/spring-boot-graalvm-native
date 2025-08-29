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

## Install GraalVM JDK 24

Using [SDKMAN](https://sdkman.io/install) (Recommended)

```bash
sdk install java 24.0.2-graal
```

[Install GraalVM JDK 24](https://www.graalvm.org/latest/getting-started/) <br>
Set ``GRAALVM_HOME`` as environment path.

## Clone this repository:

```bash
git clone https://github.com/deepaksorthiya/spring-boot-graalvm-native.git
cd spring-boot-graalvm-native
```

## Build Project Using Native Profile:

```bash
./mvnw -Pnative native:compile
```

It will generate a ```spring-boot-graalvm-native``` in ```target``` folder.

## Run Project:

```bash
./target/spring-boot-graalvm-native
```

## Build Docker Image(docker should be running):

Check [pom.xml](pom.xml) for native container image config

```xml

<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
        <image>
            <name>deepaksorthiya/${project.artifactId}:latest</name>
            <publish>false</publish>
            <createdDate>${maven.build.timestamp}</createdDate>
            <builder>bellsoft/buildpacks.builder:musl</builder>
            <env>
                <BP_NATIVE_IMAGE>true</BP_NATIVE_IMAGE>
                <BP_JVM_VERSION>24</BP_JVM_VERSION>
            </env>
        </image>
        <layers>
            <enabled>true</enabled>
        </layers>
    </configuration>
</plugin>
```

```bash
./mvnw clean -Pnative spring-boot:build-image -DskipTests
```

```bash
docker build --progress=plain -f Dockerfile.native -t deepaksorthiya/spring-boot-graalvm-native .
```

## Running On Docker

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

* [Spring Boot GraalVM](https://docs.spring.io/spring-boot/how-to/native-image/developing-your-first-application.html)
* [GraalVM Oracle Docs](https://docs.oracle.com/en/graalvm/jdk/24/docs/)
* [GraalVM Native Dockerfile](https://www.graalvm.org/latest/reference-manual/native-image/guides/containerise-native-executable-and-run-in-docker-container/)
* [Build Java Apps with Paketo Buildpacks](https://paketo.io/docs/howto/java/)
* [GraalVM Native Image Support](https://docs.spring.io/spring-boot/reference/packaging/native-image/introducing-graalvm-native-images.html)
* [Configure AOT settings in Build Plugin](https://docs.spring.io/spring-boot/how-to/aot.html)
* [Create an OCI image](https://docs.spring.io/spring-boot/maven-plugin/build-image.html)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/reference/actuator/index.html)
* [Spring Web](https://docs.spring.io/spring-boot/reference/web/servlet.html)

## Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)


