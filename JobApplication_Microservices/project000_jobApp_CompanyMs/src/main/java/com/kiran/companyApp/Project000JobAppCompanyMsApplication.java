package com.kiran.companyApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.kiran") 
@EnableJpaRepositories(basePackages =  { "com.kiran.company"})
@EntityScan(basePackages = {"com.kiran.company"})
public class Project000JobAppCompanyMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project000JobAppCompanyMsApplication.class, args);
	}

}
