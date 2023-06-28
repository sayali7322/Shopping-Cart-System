package org.springframework.boot.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.userservice.dto.SignupDTO;
import org.springframework.boot.userservice.dto.UserDTO;
import org.springframework.boot.userservice.entrity.User;
import org.springframework.boot.userservice.enums.UserRole;
import org.springframework.boot.userservice.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDTO createUser(SignupDTO signupDTO) {
        User user = new User();
        user.setUserName(signupDTO.getUserName());
        user.setUserEmail(signupDTO.getUserEmail());
        user.setUserRole(UserRole.CUSTOMER);
        user.setPassword(new BCryptPasswordEncoder().encode(signupDTO.getPassword()));
        User createdUser = userRepository.save(user);
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(createdUser.getUserId());
        userDTO.setUserName(createdUser.getUserName());
        userDTO.setUserEmail(createdUser.getUserEmail());
        userDTO.setUserRole(createdUser.getUserRole());
        return userDTO;
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.findByUserEmail(email) != null;
    }

}
