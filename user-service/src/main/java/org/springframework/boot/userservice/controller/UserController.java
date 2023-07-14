package org.springframework.boot.userservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.userservice.dto.JwtRequest;
import org.springframework.boot.userservice.dto.JwtResponse;
import org.springframework.boot.userservice.entrity.User;
import org.springframework.boot.userservice.filter.JwtAuthFilter;
import org.springframework.boot.userservice.service.JwtService;
import org.springframework.boot.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authmanager;
	
	 @Autowired
	 public PasswordEncoder passwordEncoder;
	    
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
		return service.getAllUsers(); 
	}
	
	@GetMapping("/getUserById/{userId}")
	public User getUserById(@PathVariable int userId) {
		return service.findUserById(userId);
	}
	
	@GetMapping("/getUserByEmail/{userEmail}")
	public User fetchUserByEmailId(String userEmail) {
		return service.fetchUserByEmailId(userEmail);
	}
	
	@PostMapping("/registerUser")
	@CrossOrigin(origins = "http://localhost:4200")
	public Object addUser(@RequestBody User user) throws Exception{
		String tempEmailId = user.getUserEmail();
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			User userobj =  service.fetchUserByEmailId(tempEmailId);
			if(userobj != null) {
				throw new Exception("user with "+tempEmailId+" is already exist");
			}
		}
		Object userObj = null;
		userObj = service.register(user);
		return userObj;
	}
	

	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<User> loginUser(@RequestBody User user) throws Exception {
	    String tempEmailId = user.getUserEmail();
	    String tempPassword = user.getPassword();

	    if (tempEmailId != null && tempPassword != null) {
	        // Retrieve the user from the database based on the email
	        User userFromDatabase = service.fetchUserByEmailId(tempEmailId);

	        if (userFromDatabase != null) {
	            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	            // Compare the input password with the stored password
	            if (passwordEncoder.matches(tempPassword, userFromDatabase.getPassword())) {
	                // Passwords match, return the user
	                return ResponseEntity.ok(userFromDatabase);
	            }
	        }
	    }

	    throw new Exception("Bad Credentials!");
	}
	
	@DeleteMapping("/removeUser/{userId}")
	public String removeUser(@PathVariable int userId) {
		return service.removeUser(userId);
	}
	
	
//	public String authenticateAndGetToken(@RequestBody JwtRequest authrequest) {
//		Authentication auth = authmanager.authenticate(new UsernamePasswordAuthenticationToken(authrequest.getUserEmail(),authrequest.getPassword()));
//		if(auth.isAuthenticated()) {
//			return jwtService.generateToken(authrequest.getUserEmail());
//		}
//		else {
//			throw new UsernameNotFoundException("Could not found the user :"+authrequest.getUserEmail());
//		}
//	}
	
	/*
	 * @PostMapping("/authenticate")
	 * 
	 * @CrossOrigin(origins = "http://localhost:4200") public
	 * ResponseEntity<Map<String, String>> login(@RequestBody User user) { String
	 * emailId = user.getUserEmail(); String password = user.getPassword();
	 * 
	 * try { // Attempt authentication Authentication authentication =
	 * authmanager.authenticate(new UsernamePasswordAuthenticationToken(emailId,
	 * password));
	 * 
	 * // Authentication successful UserDetails userDetails = (UserDetails)
	 * authentication.getPrincipal(); String token =
	 * jwtService.generateToken(emailId); // Pass UserDetails to include authority
	 * information
	 * 
	 * // Return the JWT token in the response Map<String, String> response = new
	 * HashMap<>(); response.put("token", token); return
	 * ResponseEntity.ok().body(response); } catch (AuthenticationException e) { //
	 * Authentication failed, handle the exception return
	 * ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); } }
	 */
	
	
	@PostMapping("/authenticate")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
	    String emailId = user.getUserEmail();
	    String password = user.getPassword();
	    
	    try {
	        // Attempt authentication
	        Authentication authentication = authmanager.authenticate(new UsernamePasswordAuthenticationToken(emailId, password));

	        // Authentication successful
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	        String token = jwtService.generateToken(emailId); // Pass UserDetails to include authority information
	        // Return the JWT token and user details in the response
	        Map<String, Object> response = new HashMap<>();
	        response.put("token", token);
	         // Add user details to the response

	        return ResponseEntity.ok().body(response);
	    } catch (AuthenticationException e) {
	        // Authentication failed, handle the exception
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	    }
	}
	
	@GetMapping("/getCurrentUser")
	public String getCurrentUser() {
		return JwtAuthFilter.CURRENT_USER;
	}

}
