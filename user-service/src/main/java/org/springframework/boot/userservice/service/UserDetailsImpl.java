package org.springframework.boot.userservice.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Objects;
import org.springframework.boot.userservice.entrity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	
	  private static final long serialVersionUID = 1L;
	  private int userId;
	  private String userName;
	  private String userEmail;
	  @JsonIgnore
	  private String password;
	  private Collection<? extends GrantedAuthority> authorities;
	  public UserDetailsImpl(int userId, String userName, String userEmail, String password,
	      Collection<? extends GrantedAuthority> authorities) {
	    this.userId = userId;
	    this.userName = userName;
	    this.userEmail = userEmail;
	    this.password = password;
	    this.authorities = authorities;
	  }
	  
	  public static UserDetailsImpl build(User user) {
		    List<GrantedAuthority> authorities = new ArrayList<>();
		    authorities.add(new SimpleGrantedAuthority(user.getUserRole()));
		    return new UserDetailsImpl(
		        user.getUserId(), 
		        user.getUserName(), 
		        user.getUserEmail(),
		        user.getPassword(), 
		        authorities);
		  }

	  @Override
	  public Collection<? extends GrantedAuthority> getAuthorities() {
	    return authorities;
	  }
	  public int getUserId() {
	    return userId;
	  }
	  public String getUserEmail() {
	    return userEmail;
	  }
	  
	  @Override
	  public String getUsername() {
		return userName;
	  }
	  
	  @Override
	  public String getPassword() {
	    return password;
	  }
	  
	  @Override
	  public boolean isAccountNonExpired() {
	    return true;
	  }
	  @Override
	  public boolean isAccountNonLocked() {
	    return true;
	  }
	  @Override
	  public boolean isCredentialsNonExpired() {
	    return true;
	  }
	  @Override
	  public boolean isEnabled() {
	    return true;
	  }
	  @Override
	  public boolean equals(Object o) {
	    if (this == o)
	      return true;
	    if (o == null || getClass() != o.getClass())
	      return false;
	    UserDetailsImpl user = (UserDetailsImpl) o;
	    return Objects.equals(userId, user.userId);
	  }

	}
