package com.kiran.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Project000ServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project000ServiceRegistryApplication.class, args);
	}

}
