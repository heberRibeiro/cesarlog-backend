package com.unit.cesarlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CesarlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CesarlogApplication.class, args);
	}
}
