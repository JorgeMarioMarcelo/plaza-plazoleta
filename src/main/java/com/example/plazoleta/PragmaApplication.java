package com.example.plazoleta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PragmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PragmaApplication.class, args);
	}

}
