package org.springframework.boot.userservice.service;

import org.springframework.boot.userservice.dto.SignupDTO;
import org.springframework.boot.userservice.dto.UserDTO;

public interface UserServiceInterface {
	
	UserDTO createUser(SignupDTO signupDTO);

	boolean hasUserWithEmail(String email);
	
}
