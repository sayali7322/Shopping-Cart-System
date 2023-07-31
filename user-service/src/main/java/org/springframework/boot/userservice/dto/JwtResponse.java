package org.springframework.boot.userservice.dto;

import org.springframework.boot.userservice.entrity.User;

public class JwtResponse {

	 private String userId;
	  private String userName;
	  private String userEmail;
	  private String userRole;
     private String jwtToken;
     private String type = "Bearer";
     
     
     
	public JwtResponse(String userId, String userName, String userEmail, String userRole, String jwtToken,
			String type) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userRole = userRole;
		this.jwtToken = jwtToken;
		this.type = type;
	}
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
     
     
    
}
