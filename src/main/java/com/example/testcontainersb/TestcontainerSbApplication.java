package com.example.testcontainersb;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MySQLContainer;

@SpringBootApplication
public class TestcontainerSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestcontainerSbApplication.class, args);
	}

	@Bean
	public ApplicationRunner init(CustomerRepository repo) {
		return args -> System.out.println("** Repo size: " + repo.count() + " ** ");

	}

	@TestConfiguration(proxyBeanMethods = false)
	class MyContainersConfiguration {

		@Bean
		@ServiceConnection
		MySQLContainer container() {
			return new MySQLContainer("mysql:8.0.26");

		}

	}
}
