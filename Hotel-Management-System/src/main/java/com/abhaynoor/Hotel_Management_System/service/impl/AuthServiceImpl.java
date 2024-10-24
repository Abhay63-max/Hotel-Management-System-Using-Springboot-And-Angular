package com.abhaynoor.Hotel_Management_System.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.abhaynoor.Hotel_Management_System.dto.LoginDto;
import com.abhaynoor.Hotel_Management_System.security.JwtTokenProvider;
import com.abhaynoor.Hotel_Management_System.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{

	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider jwtTokenProvider;
	
	public AuthServiceImpl(AuthenticationManager authenticationManager,JwtTokenProvider jwtTokenProvider) {
		this.authenticationManager=authenticationManager;
		this.jwtTokenProvider=jwtTokenProvider;
	}
	
	@Override
	public String login(LoginDto loginDto) {
		
		Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginDto.getUsernameOrEmail(),
				loginDto.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtTokenProvider.generateJwtToken(authentication);
		return token;
		
	}
	
}	