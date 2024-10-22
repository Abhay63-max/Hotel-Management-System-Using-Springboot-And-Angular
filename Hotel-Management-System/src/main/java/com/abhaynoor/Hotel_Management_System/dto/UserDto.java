package com.abhaynoor.Hotel_Management_System.dto;

import com.abhaynoor.Hotel_Management_System.validation.ValidEmail;
import com.abhaynoor.Hotel_Management_System.validation.ValidPassword;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@ValidPassword
public class UserDto {

	
	// Using JSR-380 for bean validation
	@NotNull
	@NotEmpty(message= "Name cannot be empty")
	private String name;
	@NotNull
	@NotEmpty(message="Email cannot be empty")
	@ValidEmail
	private String email;
	@NotNull
	@NotEmpty(message="Password cannot be empty")
	private String password;
	@NotNull
	@NotEmpty(message="Confirm Password cannot be empty")
	private String confirmationPassword;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmationPassword() {
		return confirmationPassword;
	}
	public void setConfirmationPassword(String confirmationPassword) {
		this.confirmationPassword=confirmationPassword;
	}
	
	
}
