package com.yaksha.assignment.functional;

import static com.yaksha.assignment.utils.TestUtils.businessTestFile;
import static com.yaksha.assignment.utils.TestUtils.currentTest;
import static com.yaksha.assignment.utils.TestUtils.testReport;
import static com.yaksha.assignment.utils.TestUtils.yakshaAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yaksha.assignment.config.AppConfig;
import com.yaksha.assignment.models.Order;
import com.yaksha.assignment.models.Product;

public class ECommerceJavaConfigControllerTest {

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	// Test to verify if application context loads beans correctly
	@Test
	public void testApplicationContextLoads() throws IOException {
		// Load the context using Java-based configuration
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// Retrieve beans from the context
		Product product = context.getBean(Product.class);
		Order order = context.getBean(Order.class);

		// Assert that beans are created
		boolean productLoaded = product != null;
		boolean orderLoaded = order != null;

		// Log the checks
		System.out.println("Product bean loaded: " + productLoaded);
		System.out.println("Order bean loaded: " + orderLoaded);

		// Auto-grading with yakshaAssert
		yakshaAssert(currentTest(), productLoaded && orderLoaded, businessTestFile);
	}

	// Test for default profile values
	@Test
	public void testDefaultPropertyValues() throws IOException {
		// Load the context with default profile
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// Retrieve the Product bean from the context
		Product product = context.getBean(Product.class);

		// Assert that the default product price is injected
		boolean productPriceDefault = 1000.0 == product.getPrice(); // Assuming default price is 1000.0

		// Log the result
		System.out.println("Product Price (Default Profile): " + product.getPrice());

		// Auto-grading with yakshaAssert
		yakshaAssert(currentTest(), productPriceDefault, businessTestFile);
	}

	// Test to check profile-specific bean creation (e.g., dev profile)
	@Test
	public void testProfileSpecificBeansCreation() throws IOException {
		// Load the context with the active profile (e.g., dev or prod)
		System.setProperty("spring.profiles.active", "dev"); // Or "prod" for the production profile
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// Retrieve a profile-specific bean from the context
		Product product = context.getBean(Product.class);

		// Assert that the correct product is injected based on the active profile
		boolean correctProduct = "Laptop".equals(product.getName()); // Assuming dev profile sets this value

		// Log the result
		System.out.println("Profile-specific Product Name: " + product.getName());

		// Auto-grading with yakshaAssert
		yakshaAssert(currentTest(), correctProduct, businessTestFile);
	}

	// Test to verify the active profile (dev or prod)
	@Test
	public void testActiveProfile() throws IOException {
		// Load the context with the active profile
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// Retrieve active profile from the environment
		String activeProfile = context.getEnvironment().getActiveProfiles()[0]; // Assuming only one profile is active

		// Assert that the correct profile is active
		boolean profileCorrect = "dev".equals(activeProfile); // Change this based on the profile set

		// Log the result
		System.out.println("Active Profile: " + activeProfile);

		// Auto-grading with yakshaAssert
		yakshaAssert(currentTest(), profileCorrect, businessTestFile);
	}
}
