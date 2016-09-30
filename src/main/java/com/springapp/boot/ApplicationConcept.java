package com.springapp.boot;

import com.springapp.boot.concept.ParserService;
import com.springapp.boot.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ApplicationConcept {

	private static final Logger log = LoggerFactory.getLogger(ApplicationConcept.class);

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ApplicationConcept.class, args);


	}


	@Autowired
	private ParserService parserService;


}