# TESTCONTAINERS - SQL SCHEMA
This Spring Boot project uses Testcontainers for testing persistence with a MySQL database. [_Testcontainers_](https://testcontainers.com) is a framework that uses Docker containers to run tests against dependencies, such as databases.

> This branch extends the [spring-3](https://github.com/gabrielcostasilva/testcontainers-spring/tree/spring-3) project by adding an SQL schema file that initializes the database.

## Overview
Please refer to [the commit](https://github.com/gabrielcostasilva/testcontainers-spring/commit/6a3a45b7823c036f56fa857c9e292959ae172665) to see the change. 

Adding the SQL schema is a clear example of the benefit of using Spring alongside Testcontainers. Spring injects the file and takes care of database operations before the test gets into action.