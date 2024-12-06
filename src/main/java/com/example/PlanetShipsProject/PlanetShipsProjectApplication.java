package com.example.PlanetShipsProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.PlanetShipsProject.repository")
public class 	PlanetShipsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanetShipsProjectApplication.class, args);
	}

}
