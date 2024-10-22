package com.abhaynoor.Hotel_Management_System.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abhaynoor.Hotel_Management_System.dto.JwtAuthResponse;
import com.abhaynoor.Hotel_Management_System.dto.LoginDto;
import com.abhaynoor.Hotel_Management_System.service.AuthService;

@Controller
@RequestMapping("/api/auth")
public class AuthController {

	private final AuthService authService;
	
	public AuthController(AuthService authService) {
		this.authService=authService;
	}
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto){
		String token = authService.login(loginDto);
		JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
		jwtAuthResponse.setAccessToken(token);
		
		return new ResponseEntity<>(jwtAuthResponse,HttpStatus.OK);
	}
}
