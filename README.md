# TESTCONTAINERS - DEVELOPMENT TIME
This Spring Boot project uses Testcontainers for testing persistence with a MySQL database. [_Testcontainers_](https://testcontainers.com) is a framework that uses Docker containers to run tests against dependencies, such as databases.

This project shows a clear example of Testcontainers as a replacement for _Mocks_.

> This branch extends the [original project](https://github.com/gabrielcostasilva/testcontainers-spring.git) by using Testcontainers at development time.

## Overview
Please refer to [the commit](https://github.com/gabrielcostasilva/testcontainers-spring/tree/test-main) to see the changes. 

In a nutshell, this branch uses Testcontainers as a [replacement](https://spring.io/blog/2023/06/23/improved-testcontainers-support-in-spring-boot-3-1) for `Dockerfile` or `docker-compose` files. Thus, you benefit from dynamic configuration with `@ServiceConnection` annotation. 

