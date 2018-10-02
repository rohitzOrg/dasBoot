package com.webapp.springBoot.dasBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages="com.webapp.springBoot.dasBoot.entity")
@EnableJpaRepositories(basePackages = "com.webapp.springBoot.dasBoot.repository")
public class DasBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DasBootApplication.class, args);
	}
}
