package org.springframework.boot.userservice.dto;

public class JwtRequest {
	
	private String userEmail;
	private String password;
	
	
	public JwtRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JwtRequest(String userEmail, String password) {
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
