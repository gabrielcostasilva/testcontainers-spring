# TESTCONTAINERS - SPRING
This Spring Boot project uses Testcontainers for testing persistence with a MySQL database. [_Testcontainers_](https://testcontainers.com) is a framework that uses Docker containers to run tests against dependencies, such as databases.

This project shows a clear example of Testcontainers as a replacement for _Mocks_.

> Check out our [_hello-world project_](https://github.com/gabrielcostasilva/testcontainers-hello-world.git) to get started with Testcontainers.

## Other Branches

This original project is extended in other branches, as follows:
- [spring-3](https://github.com/gabrielcostasilva/testcontainers-spring/tree/spring-3) replaces the need for setting database properties with `@ServiceConnection`.

- [test-main](https://github.com/gabrielcostasilva/testcontainers-spring/tree/test-main) benefits from `@ServiceConnection` by using Testcontainers at development time.


## Overview
This project consist of a single POJO ([`Customer`](./src/main/java/com/example/testcontainersb/Customer.java)) and its DAO ([`CustomerRepository`](./src/main/java/com/example/testcontainersb/CustomerRepository.java)). 

[`TestcontainerSbApplicationTests`](./src/test/java/com/example/testcontainersb/TestcontainerSbApplicationTests.java) is a test class responsible for loading Testcontainers and testing the persistence. The code below fully shows the test class.

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Testcontainers
class TestcontainerSbApplicationTests {

	@Autowired
	private CustomerRepository repo;

	@Container
	private static MySQLContainer container = new MySQLContainer("mysql:8.0.26");

	@DynamicPropertySource // (1)
	public static void overrideProps(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", container::getJdbcUrl);
		registry.add("spring.datasource.username", container::getUsername);
		registry.add("spring.datasource.password", container::getPassword);
		registry.add("spring.datasource.password", container::getPassword);
	}

	@Test
	void test() {
		assertEquals(0, repo.findAll().size());
	}

}
```
The code is straightforward for someone familiar with Spring Boot testing & Testcontainers. The main point is (1), where the code extract data from the container to set Spring properties.

### Discussion
Spring enables dependency injection and test slicing. However, it is not yet fully clear to me the benefits of using Testcontainers with Spring unless you already rely on Spring features. 


## Dependencies
In addition to traditional Spring Boot starters, we use `org.springframework.boot.spring-boot-testcontainers` - Spring implementation of Testcontainers, and `org.testcontainers.mysql` - Testcontainers implementation for MySQL.

## Further References

- [Testing Spring Boot With Testcontainers](https://blog.scottlogic.com/2023/02/27/testing-spring-boot-with-testcontainers.html) is a beginners tutorial that uses MongoDB instead of MySQL.

- [Spring Boot Development Mode with Testcontainers and Docker](https://piotrminkowski.com/2023/05/26/spring-boot-development-mode-with-testcontainers-and-docker/) adds Spring 3.1 features for container management.
