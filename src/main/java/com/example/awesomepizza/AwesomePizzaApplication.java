package com.example.awesomepizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/*
@SpringBootApplication
public class AwesomePizzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwesomePizzaApplication.class, args);
	}

}
 */

 @SpringBootApplication
public class AwesomePizzaApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AwesomePizzaApplication.class);
	}
  
	public static void main(String[] args) {
		SpringApplication.run(AwesomePizzaApplication.class, args);
	}  
  }