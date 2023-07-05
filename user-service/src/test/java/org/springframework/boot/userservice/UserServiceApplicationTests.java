package org.springframework.boot.userservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.userservice.controller.UserController;
import org.springframework.boot.userservice.dto.AuthRequest;
import org.springframework.boot.userservice.entrity.User;
import org.springframework.boot.userservice.service.JwtService;
import org.springframework.boot.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class UserServiceApplicationTests {

    @Mock
    private UserService userService;

    @Mock
    private JwtService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsers_Positive() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Sayali", "sayali@example.com", 1234567890, null, "Female", "Sayali123", "Admin", null));
        users.add(new User(2, "Harsh", "harsh@example.com", 1234567890, null, "Male", "Harsh123", "Customer", null));

        when(userService.getAllUsers()).thenReturn(users);

        List<User> result = userController.getAllUsers();

        assertEquals(2, result.size());
        verify(userService, times(1)).getAllUsers();
    }

  
    @Test
    public void testAddUser_UserAlreadyExists_Negative() {
        User user = new User(1, "Sayali", "sayali@example.com", 1234567890, null, "Female", "Sayali123", "Admin", null);

        when(userService.fetchUserByEmailId(user.getUserEmail())).thenReturn(user);

        assertThrows(Exception.class, () -> userController.addUser(user));

        verify(userService, times(1)).fetchUserByEmailId(user.getUserEmail());
        verify(userService, never()).register(any(User.class));
    }
    
   
    @Test
    public void testRemoveUser_Positive() {
        int userId = 1;
        String expectedMessage = "User removed successfully";

        when(userService.removeUser(userId)).thenReturn(expectedMessage);

        String result = userController.removeUser(userId);

        assertEquals(expectedMessage, result);
        verify(userService, times(1)).removeUser(userId);
    }

}