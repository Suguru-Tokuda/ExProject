package com.exProject.ExProjectAPI;

import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.exProject.domain.User;
import com.exProject.domain.UserRepository;

@SpringBootApplication
@ComponentScan(basePackages= {"com.exProject"})
@EntityScan(basePackages= {"com.exProject.domain"})
@EnableJpaRepositories(basePackages= {"com.exProject"})
public class ExProjectApiApplication {
	
	@Autowired
	private UserRepository repository;	
	
//	private static final Logger logger = LoggerFactory.getLogger(ExProjectApiApplication.class);

	public static void main(String[] args) {		
		SpringApplication.run(ExProjectApiApplication.class, args);		
	}
	
}
