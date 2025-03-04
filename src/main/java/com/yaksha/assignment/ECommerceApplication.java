package com.yaksha.assignment;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yaksha.assignment.config.AppConfig;
import com.yaksha.assignment.models.Order;

@SpringBootApplication
public class ECommerceApplication {

	public static void main(String[] args) {
		// Set the active profile (either 'dev' or 'prod')
		System.setProperty("spring.profiles.active", "dev"); // Or 'prod'

		// Load the Spring context using Java-based configuration
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// Print active profiles to confirm the correct one is set
		String[] activeProfiles = context.getEnvironment().getActiveProfiles();
		System.out.println("Active Profiles: " + String.join(", ", activeProfiles));

		// Retrieve and print Order bean
		Order order = context.getBean(Order.class);
		System.out.println(order);
	}
}
