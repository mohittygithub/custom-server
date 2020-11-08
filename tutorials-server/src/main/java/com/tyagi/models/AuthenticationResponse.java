package com.tyagi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class AuthenticationResponse {

	private final String jwt;
	
	

	public AuthenticationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}



	/* Getters and Setters */
	
	public String getJwt() {
		return jwt;
	}
}
