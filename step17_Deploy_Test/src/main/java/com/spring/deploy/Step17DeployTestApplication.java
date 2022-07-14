package com.spring.deploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.spring.api")
public class Step17DeployTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Step17DeployTestApplication.class, args);
	}

}
