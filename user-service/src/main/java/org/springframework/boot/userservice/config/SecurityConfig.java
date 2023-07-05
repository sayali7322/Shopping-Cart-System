package org.springframework.boot.userservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.userservice.filter.JwtAuthFilter;
import org.springframework.boot.userservice.service.CartUserUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	
	@Autowired
	private JwtAuthFilter filter;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new CartUserUserDetailsService();
	}
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//        
		return http.csrf().disable()
	            .authorizeRequests()
	            .requestMatchers(request -> {
	                String servletPath = request.getServletPath();
	                return "/user/registerUser".equals(servletPath)
	                        || "/user/authenticate".equals(servletPath)
	                        || "/user/login".equals(servletPath);
	            }).permitAll()
	            .requestMatchers(PUBLIC_URLS).permitAll()
	            .requestMatchers(request -> {
	                String servletPath = request.getServletPath();
	                return "/user/getallusers".equals(servletPath)
	                        || request.getContextPath().matches("/user/viewByEmailId/.*")
	                        || request.getContextPath().matches("/user/viewByProfileId/.*");
	            }).authenticated()
	            .and()
	            .sessionManagement()
	            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	            .and()
	            .authenticationProvider(authenticationProvider())
	            .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
	            .build();
    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	        
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
	 private static final String[] PUBLIC_URLS = { 
			 "/api/v1/auth/**",
			 "/v3/api-docs/**", 
			 "/v3/api-docs.yaml", 
			 "/swagger-ui/**",
			 "/swagger-ui.html"
	 };
			 
}
