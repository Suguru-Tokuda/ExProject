package com.executor;

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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.executor.domain.User;
import com.executor.domain.UserRepository;

@SpringBootApplication
@ComponentScan(basePackages={"com.executor"})
@EntityScan(basePackages={"com.executor.domain"})
@EnableJpaRepositories(basePackages={"com.executor"})
public class ExecutorApiApplication {
	
//	@Autowired
//	private UserRepository userRepository;
//	
//	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	public static void main(String[] args) {		
		SpringApplication.run(ExecutorApiApplication.class, args);
	}
	
//	@Bean
//	CommandLineRunner runner() {
//		return args -> {
//			userRepository.save(new User("stokuda", "Suguru", "Tokuda", "suguru.tokuda@gmail.com", encoder.encode("Sfst-0812"), "USER"));
//			userRepository.save(new User("stokuda2", "Suguru", "Tokuda", "suguru.tokuda2@gmail.com", encoder.encode("Sfst-0812"), "USER"));
//		};
//	}
	
}
