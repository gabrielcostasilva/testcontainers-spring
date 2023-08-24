package com.example.testcontainersb;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Testcontainers
@Sql("/testcontainers-schema.sql")
class TestcontainerSbApplicationTests {

	@Autowired
	private CustomerRepository repo;

	@Container
	@ServiceConnection
	private static MySQLContainer container = new MySQLContainer("mysql:8.0.26");

	@Test
	void test() {
		assertEquals(0, repo.findAll().size());
	}

}
