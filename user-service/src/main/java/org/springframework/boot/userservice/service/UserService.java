package org.springframework.boot.userservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.userservice.entrity.User;
import org.springframework.boot.userservice.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	
	  	@Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private JwtService jwtService;

	    @Autowired
	    public PasswordEncoder passwordEncoder;
	    
	    @Autowired
	    private AuthenticationManager authenticationManager;


	public User findUserById(int userId) {
		User user = userRepository.findById(userId).orElse(null);
		return user;	
	}

//	public List<User> addUsers(List<User> users) {
//		return userRepository.saveAll(users);
//	}

	public String register(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "User added Successfully";
	}
	
	public User fetchUserByEmailId(String userEmail) {
		return userRepository.findByUserEmail(userEmail);
	}
	
	public User fetchUserByEmailIdAndPassword(String userEmail, String password) {
		return userRepository.findByUserEmailAndPassword(userEmail, password);
	}

	public String removeUser(int userId) {
		userRepository.deleteById(userId);
		return "User Deleted Successfully";
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
//	 public String authenticate(User request) throws Exception {
//	        
//	        try{
//	            authenticationManager.authenticate(
//	                    new UsernamePasswordAuthenticationToken(
//	                            request.getUserEmail(),
//	                            request.getPassword()));
//	        }catch(Exception e){
//	            throw new Exception("invalid username or password");
//	        }
//
//	        String token = jwtService.generateToken(request.getUserEmail());
//	        User user = userRepository.findByUserEmail(request.getUserEmail());
//	        user.setAccess_token(token);
//	        userRepository.save(user);
//	        return token;
//
//	        } 

}
