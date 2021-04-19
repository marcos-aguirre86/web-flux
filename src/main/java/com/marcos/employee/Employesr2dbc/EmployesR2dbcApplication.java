package com.marcos.employee.Employesr2dbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class EmployesR2dbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployesR2dbcApplication.class, args);
	}

}
