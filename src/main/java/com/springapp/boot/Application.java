package com.springapp.boot;

import com.springapp.boot.service.BookingService;
import javafx.print.Collation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * @SpringBootApplication is a convenience annotation that adds all of the following:
 * 	@Configuration tags the class as a source of bean definitions for the application context.
 * 	@EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
 * 	Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath.
 * 	This flags the application as a web application and activates key behaviors such as setting up a DispatcherServlet.
 * 	@ComponentScan tells Spring to look for other components, configurations, and services in the the .. package,
 * 	allowing it to find the Controllers.
 */
@SpringBootApplication
@EnableScheduling
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		/*System.out.println("Let's inspect the beans provided by Spring Boot:");

		List<String> beans = Arrays.asList(ctx.getBeanDefinitionNames());
		beans.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);

		System.out.println("-------------------------------------------------");

		BookingService bookingService = ctx.getBean(BookingService.class);
		bookingService.book("Alice", "Bob", "Carol");
		assertEquals("First booking should work with no problem", 3, bookingService.findAllBookings().size());

		try {
			bookingService.book("Chris", "Samuel");
		}
		catch (RuntimeException e) {
			log.info("v--- The following exception is expect because 'Samuel' is too big for the DB ---v");
			log.error(e.getMessage());
		}


		bookingService.findAllBookings().forEach(person -> log.info("So far, " + person + " is booked."));

		log.info("You shouldn't see Chris or Samuel. Samuel violated DB constraints, and Chris was rolled back in the same TX");
		assertEquals("'Samuel' should have triggered a rollback", 3, bookingService.findAllBookings().size());

		try {
			bookingService.book("Buddy", null);
		}
		catch (RuntimeException e) {
			log.info("v--- The following exception is expect because null is not valid for the DB ---v");
			log.error(e.getMessage());
		}

		bookingService.findAllBookings().forEach(person -> log.info("So far, " + person + " is booked."));

		log.info("You shouldn't see Buddy or null. null violated DB constraints, and Buddy was rolled back in the same TX");
		assertEquals("'null' should have triggered a rollback", 3, bookingService
				.findAllBookings().size());*/
	}


	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/greet-javaconfig").allowedOrigins("http://localhost:9000");
			}
		};
	}

	@Bean
	BookingService bookingService() {
		return new BookingService();
	}

	@Bean
	JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		log.info("Creating tables");
		jdbcTemplate.execute("drop table BOOKINGS if exists");
		jdbcTemplate.execute("create table BOOKINGS("
				+ "ID serial, FIRST_NAME varchar(5) NOT NULL)");
		return jdbcTemplate;
	}




}