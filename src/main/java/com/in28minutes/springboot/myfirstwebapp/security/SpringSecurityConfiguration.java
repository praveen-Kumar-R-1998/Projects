package com.in28minutes.springboot.myfirstwebapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {

	Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

	@Bean
	public InMemoryUserDetailsManager createUserDetailManager() {
		UserDetails userDetails = User.builder()
									.passwordEncoder(passwordEncoder)
									.username("study")
									.password("study")
									.roles("USER", "ADMIN").build();
		
		return new InMemoryUserDetailsManager(userDetails);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
