package com.kiran.reviewApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.kiran") 
@EnableJpaRepositories(basePackages =  { "com.kiran.review"})
@EntityScan(basePackages = { "com.kiran.review"})
public class Project000JobAppReviewMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project000JobAppReviewMsApplication.class, args);
	}

}
