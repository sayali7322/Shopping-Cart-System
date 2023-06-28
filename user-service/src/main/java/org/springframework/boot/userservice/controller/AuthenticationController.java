package org.springframework.boot.userservice.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.el.parser.Token;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.userservice.dto.AuthenticationRequest;
import org.springframework.boot.userservice.entrity.User;
import org.springframework.boot.userservice.repository.UserRepository;
import org.springframework.boot.userservice.service.UserService;
import org.springframework.boot.userservice.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;

@RestController
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    @PostMapping("/authenticate")
    public void createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException, JSONException, ServletException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect username or password.");
        } catch (DisabledException disabledException) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "User is not activated");
            return;
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
        User user = userRepository.findByUserEmail(userDetails.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        response.getWriter().write(new JSONObject()
                .put("userId", user.getUserId())
                .put("role", user.getUserRole())
                .toString()
        );
        response.addHeader("Access-Control-Expose-Headers", "Authorization");
        response.addHeader("Access-Control-Allow-Headers", "Authorization, X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept, X-Custom-header");
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + jwt);
    }

}