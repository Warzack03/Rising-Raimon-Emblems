package com.rising.raimon.stock.application;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties
@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server URL")})
@ComponentScan("com.rising.raimon.stock")
@EntityScan(basePackages = {"com.rising.raimon.stock.infrastructure.persistence.entities"})
@EnableJpaRepositories(basePackages = {"com.rising.raimon.stock.infrastructure.persistence.repository"})
public class StockApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}

}
