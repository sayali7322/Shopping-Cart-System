package org.springframework.boot.userservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.userservice.entrity.User;
import org.springframework.boot.userservice.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl {
	
	@Autowired
	UserRepository userRepository;
	
	//@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		//User user = userRepository.getUserByUserName(username);
//		
////		if(user == null) {
////			throw new UsernameNotFoundException("Could not found user !");
////		}
//
//		//CustomUserDetails customUserDetails = new CustomUserDetails(user);
//		//return customUserDetails;
//	}

}
