package com.madhu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
public class SecurityConfig {

	@Autowired
	private JwtEntryPoint jwtEntryPoint;
	
	@Autowired
	private JwtAuthFilter jwtAuthFilter;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		
		//http.authorizeHttpRequests(t->t.anyRequest().permitAll());
		
		http.authorizeHttpRequests(
				t -> t.requestMatchers("/public/**", "/auth/**").permitAll().anyRequest().authenticated());

		http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
		
		http.exceptionHandling(e -> e.authenticationEntryPoint(jwtEntryPoint));

		
		http.csrf(t -> t.disable());


		http.cors(t -> t.disable());

		http.sessionManagement(t -> t.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		
		
		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
