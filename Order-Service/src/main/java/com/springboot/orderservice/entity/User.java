package com.springboot.orderservice.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonFormat;


@Component
public class User {

	private int userId;
	private String userName;
	private String userEmail;
	private long phoneNo;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	private String gender;
	private String password;
	private String userRole;
	
	
	/*
	 * public User() {
	 * 
	 * }
	 * 
	 * public User(int userId, String userName, String userEmail, long phoneNo,
	 * LocalDate dateOfBirth, String gender, String password, String userRole) {
	 * super(); this.userId = userId; this.userName = userName; this.userEmail =
	 * userEmail; this.phoneNo = phoneNo; this.dateOfBirth = dateOfBirth;
	 * this.gender = gender; this.password = password; this.userRole = userRole; }
	 */

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setRole(String userRole) {
		this.userRole = userRole;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	
}
