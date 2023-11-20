package com.example.gestaoOrcamentaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.example.gestaoOrcamentaria.repository")
@SpringBootApplication
public class GestaoOrcamentariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoOrcamentariaApplication.class, args);
	}

}
