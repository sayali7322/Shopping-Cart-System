package org.springframework.boot.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private String jwtToken;

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	
	public  AuthenticationResponse() {
		
	}

	public AuthenticationResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}
    
    

}
