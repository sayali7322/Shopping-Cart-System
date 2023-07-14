package com.springboot.orderservice.externalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.orderservice.entity.User;

@FeignClient(name="user-service", url="http://localhost:8082/")
public interface UserService {
	
	@GetMapping("/getUserById/{userId}")
	public User getUserById(@PathVariable int userId);
	
	@GetMapping("/getCurrentUser")
	public String getCurrentUser();
	
	@GetMapping("/getUserByEmail/{userEmail}")
	public User fetchUserByEmailId(String userEmail);
}
