# mollysclub-api

![example workflow](https://github.com/philz-stizles/mollysclub-api/actions/workflows/tests-mollysclub.yml/badge.svg) ![Coverage](.github/badges/jacoco.svg) ![Branches](.github/badges/branches.svg)

<!-- [![CircleCI](https://circleci.com/gh/philz-stizles/mollysclub-api/tree/main.svg?style=svg)](https://circleci.com/gh/philz-stizles/mollysclub-api/tree/main) -->

## Introduction

mvn spring-boot:run

## Development Tools

Chrome extension:

RemoteLiveReload

```bash
  netstat -ano | findstr :<PORT>

  taskkill /PID <PID> /F
```

maildev

docker run -p 1080:80 -p 1025:25 djfarrelly/maildev

```bash
npm install -g maildev
```

run mail server:

```bash
  maildev
```

## Swagger

    - Setup:
      - pom.xml

        ```xml
        ```

    - Access swagger docs locally:

        http://localhost:8080/swagger-ui/

## Project Lombok

Ensure to enable annotation processing where necessary depending on IDE, for example using web
pom.xml:

```xml
  <dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
  </dependency>
```

## H2

http://localhost:8080/h2-console

## Project Lombok

- Install Lombok Annotation extension in VS Code
- Configure pom.xml:

  ```xml
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
    </dependency>
  ```

- Short:

## Web Jars

```xml
  <dependency>
      <groupId>org.webjars</groupId>
      <artifactId>bootstrap</artifactId>
      <version>5.1.0</version>
  </dependency>
```

usage:

```html

```

## Spring Data Validation

```xml
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
  </dependency>
```

## JUnit Test

- Install Lombok Annotation extension in VS Code
- Configure pom.xml:

  ```xml
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <scope>test</scope>
    </dependency>

    <dependency>
      <groupId>org.junit.vintage</groupId>
      <artifactId>junit-vintage-engine</artifactId>
      <scope>test</scope>
      <exclusions>
        <exclusion>
          <groupId>org.hamcrest</groupId>
          <artifactId>hamcrest-core</artifactId>
        </exclusion>
      </exclusions>
    </dependency>
  ```

## Docker

## Spring Rest Docs

## JMS Messaging

## Mongo

- Running Mongo in a docker container: PORT 27017 automatically exposed

  ```bash
   docker run --name mongo-dev --port 27017:27017 -d --mongo:latest

   docker logs -f <container-id>
  ```

## MySQL

- Running MySQL in a docker container:

  ```bash
    docker run --name mysql-dev -e MYSQL_ROOT_PASSWORD=P@ssw0rd -d mysql:latest

    docker exec -it mysql-dev bash mysql

    mysql --user=root -p

    Enter password:P@ssw0rd
  ```

- Create local instance: Run natively

  - Create database:

    ```bash
      CREATE DATABASE javakit_dev;
      CREATE DATABASE javakit_prod;
    ```

  - Create username & password:

    ```bash
      CREATE USER 'javakit_dev_admin'@'localhost' IDENTIFIED BY 'p@ssw0rd';
      GRANT SELECT ON javakit_dev.* TO 'javakit_dev_admin'@'localhost';
      GRANT INSERT ON javakit_dev.* TO 'javakit_dev_admin'@'localhost';
      GRANT DELETE ON javakit_dev.* TO 'javakit_dev_admin'@'localhost';
      GRANT UPDATE ON javakit_dev.* TO 'javakit_dev_admin'@'localhost';

      CREATE USER 'javakit_prod_admin'@'localhost' IDENTIFIED BY 'p@ssw0rd';
      GRANT SELECT ON javakit_prod.* TO 'javakit_prod_admin'@'localhost';
      GRANT INSERT ON javakit_prod.* TO 'javakit_prod_admin'@'localhost';
      GRANT DELETE ON javakit_prod.* TO 'javakit_prod_admin'@'localhost';
      GRANT UPDATE ON javakit_prod.* TO 'javakit_prod_admin'@'localhost';
    ```

## AWS S3

    {
      "Version":"2012-10-17",
      "Statement":[
        {
          "Sid":"PublicRead",
          "Effect":"Allow",
          "Principal": "*",
          "Action":["s3:GetObject"],
          "Resource":["arn:aws:s3:::examplebucket/*"]
        }
      ]
    }

## JMS

publishing and subscribing to messages using a JMS broker.
Apache ActiveMQ

## Spring Boot properties

- Overview:

  - Supports yaml-based files.
  - The properties file path can be customized. For example, while running the
  - @Value Annotation: Spring boot will throw the Illegal argument exception if any of these properties are not found.

    ```java
      @Value("${mollysclub.jwt.secret}")
      private String jwtSecret;
    ```

  - Priority:
    Command-line > JVM Parameters > OS System variables > ClassPath

  - Spring Boot tries to find the properties file in the following order:

    Under "config" folder > Current Directory > Under "config" folder under class path > Root class path

- java -jar myJar.jar --property=values

## Test Runners

- Git actions
- Circle CI

## Code Coverage [Not compatible with Java 11]

- Using Codecov with Circle CI - (See [https://docs.codecov.com/docs](docs))

  - Sign up [https://docs.codecov.com](here)
  - Configure for Java Maven:

    - [https://docs.codecov.com/docs/supported-languages](List of language configs)
    - [https://github.com/codecov/example-java-maven](Maven configs)

    ```xml
      <plugin>
          <groupId>org.codehaus.mojo</groupId>
          <artifactId>cobertura-maven-plugin</artifactId>
          <version>2.7</version>
          <configuration>
              <formats>
                  <format>html</format>
                  <format>xml</format>
              </formats>
              <check />
          </configuration>
      </plugin>
    ```

  - Configure yml CI file:

    ```yml
    # run tests!
    - run: mvn integration-test cobertura:cobertura

    - store_test_results:
        path: target/surefire-reports

    - run:
        name: Send to CodeCov
        command: bash <(curl -s https://codecov.io/bash)
    ```

## Cron Jobs

@EnableScheduling
Add @EnableScheduling annotation to your spring boot application class.
@EnableScheduling is a Spring Context module annotation.
It internally imports the SchedulingConfiguration via the @Import(SchedulingConfiguration.class) instruction

- Authentication auth = SecurityContextHolder.getContext().getAuthentication();
  he authentication instance now provides the following methods:

Get the username of the logged in user: getPrincipal()
Get the password of the authenticated user: getCredentials()
Get the assigned roles of the authenticated user: getAuthorities()
Get further details of the authenticated user: getDetails()

Git clone a specific branch
In order to clone a specific branch, you have to execute “git branch” with the “-b” and specify the branch you want to clone.

$ git clone -b <branch> <remote_repo>
