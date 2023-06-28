package org.springframework.boot.userservice.entrity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.boot.userservice.enums.UserRole;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	private String userEmail;
	private long phoneNo;
	@JsonFormat(pattern = "mm/dd/yyyy")
	private LocalDate dateOfBirth;
	private String gender;
	private String password;
	private UserRole userRole;
	private byte[] img;
	
	@Transient
	private List<Rating> ratings;
	
	public User() {
		
	}
	

	public User(int userId, String userName, String userEmail, long phoneNo, LocalDate dateOfBirth, String gender,
			String password, UserRole userRole, byte[] img, List<Rating> ratings) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.phoneNo = phoneNo;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.password = password;
		this.userRole = userRole;
		this.img = img;
		this.ratings = ratings;
	}



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

//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	
}
