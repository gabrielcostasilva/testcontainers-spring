package com.example.testcontainersb;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.example.testcontainersb.TestcontainerSbApplication.MyContainersConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TestcontainerSbApplicationTests {

	public static void main(String[] args) {
        SpringApplication
			.from(TestcontainerSbApplication::main)
			.with(MyContainersConfiguration.class)
			.run(args);
    }

}
