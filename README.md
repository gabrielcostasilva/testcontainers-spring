# TESTCONTAINERS - SPRING
This Spring Boot project uses Testcontainers for testing persistence with a MySQL database. [_Testcontainers_](https://testcontainers.com) is a framework that uses Docker containers to run tests against dependencies, such as databases.

This project shows a clear example of Testcontainers as a replacement for _Mocks_.

> This branch extends the [original project](https://github.com/gabrielcostasilva/testcontainers-spring.git) by replacing DynamicProperties with the new added feature `@ServiceConnection`.

## Overview
Please refer to [the commit](https://github.com/gabrielcostasilva/testcontainers-spring/commit/ac0876a6ff1310ce32df732ea33ff918eeb409a7) to see the change. Check out [this article](https://spring.io/blog/2023/06/23/improved-testcontainers-support-in-spring-boot-3-1) to better understand the `@ServiceConnection` feature.

## Further References on `@ServiceConnection`

- [Spring Boot @ServiceConnection](https://howtodoinjava.com/spring-boot/spring-boot-service-connection-example/) complements [the article](https://spring.io/blog/2023/06/23/improved-testcontainers-support-in-spring-boot-3-1) mentioned in this repo.

