package com.tn.actuals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@EnableCaching
@SpringBootApplication
@ComponentScan("com.tn")
@EntityScan( basePackages = {"com.tn"})
public class TNApplication {

	public static void main(String[] args) {
		SpringApplication.run(TNApplication.class, args);
	}

}
