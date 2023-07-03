package org.springframework.boot.userservice.dto;

public class AuthRequest {
	
	private String userEmail;
	private String password;
	
	
	public AuthRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthRequest(String userEmail, String password) {
		super();
		this.userEmail = userEmail;
		this.password = password;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUsername(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
