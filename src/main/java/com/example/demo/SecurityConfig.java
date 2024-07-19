package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
//	private static final String[] AUTH_WHITELIST = "/api/v1/add/country";

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {

		UserDetails user1 = User.withUsername("manoj").password(passwordEncoder().encode("manoj")).roles("USER")
				.build();

		UserDetails user2 = User.withUsername("paplu").password(passwordEncoder().encode("paplu")).roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user1, user2);
	}

	// This configuration will all allow any request that is authenticated with
	// basic form based authentication
	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
	 * Exception {
	 * 
	 * http.authorizeHttpRequests(auth->auth.anyRequest().authenticated())
	 * .httpBasic(Customizer.withDefaults());
	 * 
	 * return http.build(); }
	 */

/*	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf->csrf.disable())
				.authorizeHttpRequests(auth->auth.requestMatchers("/api/v1/greetings").permitAll())
				.authorizeHttpRequests(
				 auth -> auth.requestMatchers("/api/v1/add/country").hasRole("USER").anyRequest().authenticated())
				
				.httpBasic(Customizer.withDefaults());

	//	http.csrf(AbstractHttpConfigurer::disable); 

		return http.build();

	}  */
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf->csrf.disable())
				.authorizeHttpRequests(auth->auth.requestMatchers(new AntPathRequestMatcher("/api/v1/greetings")).permitAll())
				.authorizeHttpRequests(
				 auth -> auth.requestMatchers(new AntPathRequestMatcher("/api/v1/countries/**")).hasAnyRole("USER","ADMIN").anyRequest().authenticated())
				
				.httpBasic(Customizer.withDefaults());

	//	http.csrf(AbstractHttpConfigurer::disable); 

		return http.build();

	}


}
