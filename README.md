# mollysclub-api

## Introduction

## Development Tools

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

# Java Kit

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

## MySQL

- Create local instance: Run natively or in a docker container
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
