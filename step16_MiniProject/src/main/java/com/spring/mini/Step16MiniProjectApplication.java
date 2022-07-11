package com.spring.mini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages = {"com.spring.entity"})
@EnableJpaRepositories(basePackages = {"com.spring.repository"})
@ComponentScan(basePackages = {"com.spring.api", "com.spring.service", "com.spring.dto"})
public class Step16MiniProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Step16MiniProjectApplication.class, args);
	}

}
