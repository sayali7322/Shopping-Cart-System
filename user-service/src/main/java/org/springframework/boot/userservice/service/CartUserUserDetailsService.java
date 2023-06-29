package org.springframework.boot.userservice.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.userservice.config.CartUserUserDetails;
import org.springframework.boot.userservice.entrity.User;
import org.springframework.boot.userservice.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class CartUserUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> cartUser = Optional.of(repo.findByUserEmail(userName));
		return cartUser.map(CartUserUserDetails::new)
				.orElseThrow(()-> new UsernameNotFoundException("User NOT Found : "+userName));
		
	}

}

