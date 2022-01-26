package com.ensa.backofficeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients("com.ensa.backofficeservice.service")
@EnableScheduling
public class BackofficeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackofficeServiceApplication.class, args);
	}

}
