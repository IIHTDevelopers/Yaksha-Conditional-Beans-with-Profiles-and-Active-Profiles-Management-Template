package com.yaksha.assignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.yaksha.assignment.models.Order;
import com.yaksha.assignment.models.Product;

@Configuration
public class AppConfig {

	// Define Product bean for dev profile
	@Bean
	@Profile("dev")
	public Product product() {
		return new Product("Laptop", 1000.0);
	}

	// Define Product bean for prod profile
	@Bean
	@Profile("prod")
	public Product productForProd() {
		return new Product("Smartphone", 500.0);
	}

	// Define Order bean (always available)
	@Bean
	public Order order(Product product) { // Inject Product based on the active profile
		return new Order("ORD12345", 1500.0, product);
	}
}
