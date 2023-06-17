package org.springframework.boot.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.userservice.entrity.User;
import org.springframework.boot.userservice.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public User findUserById(int userId) {
		User user = userRepository.findById(userId).orElse(null);
		return user;	
	}

	public List<User> addUsers(List<User> users) {
		return userRepository.saveAll(users);
	}

	public User addUser(User user) {
		return userRepository.save(user);
		
	}

	public String removeUser(int userId) {
		userRepository.deleteById(userId);
		return "User Deleted Successfully";
	}

}
