package com.abhaynoor.Hotel_Management_System.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.abhaynoor.Hotel_Management_System.dto.UserDto;
import com.abhaynoor.Hotel_Management_System.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private final UserService userService;
	
	public UserController( UserService userService) {
		this.userService=userService;
	}
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody @Valid UserDto userDto) {
		userService.registerUser(userDto);
		return new ResponseEntity<>("User registered Successfully",HttpStatus.CREATED);
	}
	@GetMapping("/test")
	public String testEndpoint() {
		return "test Successfull";
	}
	
}
