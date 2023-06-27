package org.springframework.boot.userservice.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.userservice.filters.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.http.SessionCreationPolicy;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
		
//	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.csrf().disable()
//		.authorizeHttpRequests()
//		.requestMatchers("/user/login","/user/registerUser", "/product/viewAllProducts","/product/viewProductByProdId/**","/product/viewProductsByCategory/**","/product/viewProductByProdName/**").permitAll()
//		.requestMatchers("/user/getAllUsers","/user/getUserById/**","/user/removeUser/**","/product/addProducts","/product/addProduct","/product/removeProduct/**").hasRole("Admin")
//		.and().formLogin();
//		
//		return httpSecurity.build();
//	}
	
	 	@Autowired
	    private JwtRequestFilter authFilter;

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        return http.csrf().disable()
	                .authorizeHttpRequests()
	                .requestMatchers("/user/login", "/user/registerUser").permitAll()
	                .and()
	                .authorizeHttpRequests().requestMatchers("/api/**")
	                .authenticated().and()
	                .sessionManagement()
	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	                .and()
	                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
	                .build();
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
	        return config.getAuthenticationManager();
	    }

		
}
