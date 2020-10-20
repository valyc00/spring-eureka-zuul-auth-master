package com.personal.auth;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.personal.auth.domain.User;
import com.personal.auth.repository.UserRepository;
import com.personal.common.security.JwtTokenDeconstructor;

@SpringBootApplication
@EnableEurekaClient
public class AuthServiceApplication {
	
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
		
		
		
	}

	@Bean
	public JwtTokenDeconstructor jwtTokenDeconstructor() {
		return new JwtTokenDeconstructor();
	}
	
	@Bean
	public void storeData() {
		
		User user = new User();
		user.setFirstName("admin");
		user.setLastName("admin");
		user.setUsername("admin");
		user.setPassword(new BCryptPasswordEncoder().encode("admin"));
		user.setDob(new Date());
		user.setPhoneNumber("1234");
		user.setGender("M");
		
		
		userRepository.save(user);
		System.out.println("user admin saved!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
}
