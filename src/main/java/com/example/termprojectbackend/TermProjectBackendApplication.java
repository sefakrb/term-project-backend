package com.example.termprojectbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TermProjectBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TermProjectBackendApplication.class, args);
	}

}